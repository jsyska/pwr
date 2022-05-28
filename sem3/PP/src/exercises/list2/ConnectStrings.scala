package exercises.list2

object ConnectStrings extends App{

//  def connectStrings(listOfString: List[String], separator: String):String = {
//    if(listOfString.isEmpty) ""
//    else listOfString.head + separator + connectStrings(listOfString.tail, separator)
//  }

  def connectStrings(listOfString: List[String], separator: String):String = {
    def helper(list:List[String], separator: String, acc:String): String = list match {
      case Nil => acc
      case h::t => helper(t, separator, acc + h  + separator )
    }
    helper(list,separator, "")
  }


  val list = List("a","b","d","e")
  println(connectStrings(list,";"))


  sealed trait Operation
  case class Neg(n: Int) extends Operation
  case class Sum(a: Int, b: Int) extends Operation

  def calculator(op: Operation): Int = op match {
    case Neg(x) => -x
    case Sum(a,b) => a+b
  }

}
