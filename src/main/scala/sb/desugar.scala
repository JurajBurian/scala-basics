package sb

import scala.reflect.macros.whitebox.Context
import language.experimental.macros
import scala.language.experimental.macros


object desugar {

	def desugarImpl(c : Context)(a : c.Expr[Any])= {
		import c.universe._
		val s = show(a.tree)
		c.Expr(
			Literal(Constant(s))
		)
	}
	def apply(a: Any): String = macro desugarImpl
}