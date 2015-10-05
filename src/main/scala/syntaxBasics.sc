/**
 * value.
 * press Alt + Enter when focus on numbers
 * press Alt = when focus on numbers
 */
/*
val numbers = 1 to 10;
val fibo: Stream[Int] = 0 #:: fibo.scanLeft(1)(_ + _)
val fibosCount = 10
val fibos = for (x <- 0 to fibosCount) yield (fibo(x))
*/


/**
 * variable akka field or class member in java
 *
 */
/*
var vn = 123
vn += 12
vn // statement returns value
*/

/**
 * if statement
 */
/*
import scala.util.Random // import can be anywhere
val result = if(Random.nextBoolean()) 1 else 2
*/

/**
 * cycle
 */
/*def cycle(to:Int) = {
	var it, sum= 0
	while (it < to) {
		it += 1; sum += it
	}
	sum
}
cycle(3)*/

/**
 * classes
 */
/*
class X(var x:Int, var y:Int) {
	// second constructor
	def this(a: Int) = this(a, 0)
}
new X(x = 2, y = 4) // named parameters
*/

/*sealed trait Root
sealed trait LChild extends Root
sealed trait RChild extends Root
class Parent(a: String = "Parent") extends Root
class L(a: String = "L") extends LChild
class R(a: String = "R") extends RChild

val seq = Seq[R]()
seq
val seq2 = seq :+ new R()
seq2
val seq3=  seq2 :+ new L()
seq3*/

/*
import sb._
val src: Any = desugar(
	for(x<- 1 to 3)yield{x}
)
src
*/
