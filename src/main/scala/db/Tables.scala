package db

import slick.driver.H2Driver.api._
import slick.lifted.{ProvenShape, ForeignKeyQuery}

case class User(name:String,street:String,city:String,state:String,zip:String, id:Int)

class Users(tag: Tag)
  extends Table[User](tag, "USERS") {

  // This is the primary key column:
  def id: Rep[Int] = column[Int]("ID", O.PrimaryKey)
  def name: Rep[String] = column[String]("NAME")
  def street: Rep[String] = column[String]("STREET")
  def city: Rep[String] = column[String]("CITY")
  def state: Rep[String] = column[String]("STATE")
  def zip: Rep[String] = column[String]("ZIP")
  
	def * = (name, street, city, state, zip, id) <> (User.tupled, User.unapply)
}

// A Coffees table with 5 columns: name, supplier id, price, sales, total
class Groups(tag: Tag)
  extends Table[(String, Int)](tag, "Group") {

  def name: Rep[String] = column[String]("NAME", O.PrimaryKey)
  def userId: Rep[Int] = column[Int]("USER_ID")

  def * = (name, userId)
  
  // A reified foreign key relation that can be navigated to create a join
  def user = foreignKey("SUP_FK", userId, TableQuery[Users])(_.id)
}

class Right(tag:Tag) extends Table[(String, Int, Int)](tag, "GROUP") {
	def id: Rep[Int] = column[Int]("ID", O.PrimaryKey)
	def name: Rep[String] = column[String]("NAME")
	def groupId: Rep[Int] = column[Int]("GROUP_ID")

	def * = (name, groupId, id)

}