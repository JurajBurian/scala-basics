package db

import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import slick.backend.DatabasePublisher
import slick.driver.H2Driver.api._

// The main application
object HelloSlick extends App {
  val db = Database.forConfig("h2mem1")
  try {

    // The query interface for the Suppliers table
    val users: TableQuery[Users] = TableQuery[Users]

    // the query interface for the Coffees table
    val groups: TableQuery[Groups] = TableQuery[Groups]

    val setupAction: DBIO[Unit] = DBIO.seq(
      // Create the schema by combining the DDLs for the Suppliers and Coffees
      // tables using the query interfaces
      (users.schema ++ groups.schema).create,

      // Insert some users
      users += User("Juraj Burian", "99 Market Street", "Groundsville", "CA", "95199", 101),
      users += User("Laci Skokan", "1 Party Place", "Mendocino", "CA", "95460", 49),
      users += User("Jan Nad", "100 Coffee Lane", "Meadows", "CA", "93966", 150)
    )

    val setupFuture: Future[Unit] = db.run(setupAction)
    val f = setupFuture.flatMap { _ =>

      // Insert some groups (using JDBC's batch insert feature)
      val insertAction: DBIO[Option[Int]] = groups ++= Seq (
        ("Users",101),("Administrators",49),("Mangers",150), ("Visitors",   101))

      val insertAndPrintAction: DBIO[Unit] = insertAction.map { coffeesInsertResult =>
        // Print the number of rows inserted
        coffeesInsertResult foreach { numRows =>
          println(s"Inserted $numRows rows into the Coffees table")
        }
      }

      val allUsersAction = users.result

      val combinedAction = insertAndPrintAction >> allUsersAction

      val combinedFuture = db.run(combinedAction)

      combinedFuture.map {allUsers =>  allUsers.foreach(println) }

    }.flatMap { _ =>

      /* Streaming */

      val groupNamesAction =  groups.map(_.name).result

      val coffeeNamesPublisher: DatabasePublisher[String] =  db.stream(groupNamesAction)

      coffeeNamesPublisher.foreach(println)

    }.flatMap { _ =>

      /* Joins */

      // Join the tables using the relationship defined in the Coffees table
      val joinQuery= for {
        g <- groups if g.name === "Users"
        u <-g.user
      } yield (g.name, u)

      println("Generated SQL for the join query:\n" + joinQuery.result.statements)

      // Print the rows which contain the coffee name and the supplier name
      db.run(joinQuery.result).map(println)

    }
    Await.result(f, Duration.Inf)

  } finally db.close
}
