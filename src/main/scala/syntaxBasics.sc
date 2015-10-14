/**
 * value.
 * press Alt + Enter when focus on numbers
 * press Alt + = when focus on numbers
 */
val numbers = 1 to 10;
val fibo: Stream[Int] = 0 #:: fibo.scanLeft(1)(_ + _)
val fibosCount = 10
val fibos = for (x <- 0 to fibosCount) yield (fibo(x))

val x = "Ahoj"
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
 * function
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
