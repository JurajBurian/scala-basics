package sb

/**
 * @author jubu
 */

sealed trait R
trait LChild extends R
trait RChild extends R
case class A(a: String = "L") extends LChild
case class B(a: String = "R", l:Option[A] = None) extends RChild
case class C(a: String = "P", l:A, r:B = B()) extends R


trait Root[+X] {	val x:X}
class PR(override val x:String) extends Root[String]
class PL(override val x:Long) extends Root[Long]



case class User(name: String, orders: List[Order])
case class Order(id: Int, products: List[Product])
case class Product(id: Int, category: String)




