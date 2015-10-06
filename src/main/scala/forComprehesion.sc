import sb._

/**
 * variance example
 */
/*val seq = Seq[PR]()
seq
val seq2 = seq :+ new PR("Ahoj")
seq2
val seq3=  seq2 :+ new PL(123)
seq3*/

/**
 *  for comprehension 1
 */
/*for(v<-seq3) yield(v.x)

for(v<-seq3) {
	println (v.x)
}

desugar(
	for(v<- seq3){println (v.x)}
)*/

/**
 *  for comprehension 1
 */

/*
val user = Some(User("Janko Hrasko",
	orders = List(
		Order(1, List(Product(1, "TV"))),
		Order(2, List(Product(2, "mobile"), Product(3, "bread"))
	))))

for(u<-user)yield(for(os<-u.orders; if(os.id == 2); ps<-os.products ) yield(ps))

desugar(
	for(u<-user)yield(for(os<-u.orders; if(os.id == 2); ps<-os.products ) yield(ps))
)
*/