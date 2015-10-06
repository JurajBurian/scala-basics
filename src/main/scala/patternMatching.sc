import sb.{A, B, R}


trait  Matcher {

	 def parse(x:Any)= x match {
		 case "Ahoj" => "Ahoj ako sa mas"
		 case x:Int =>  s"prislo cislo : $x"
			case x::xs => s"prisla neprazdna kolekcia obsahujuca $x"
		 case y:R => y match {
			 case B(a, _) => s"v R prislo : $a"
			 case l@A(a) => s"prislo: $l a obsahuje $a"
			 case _ => "neviem co doslo"
		 }
	 }
 }

val m = new Matcher(){}
m.parse("Ahoj")
m.parse(B("koki", Some(A())))
m.parse(124)
m.parse(23::"Koki"::Nil)

