package labs.lab3

object Task4 extends App{

  def wrap(leftWrapper:String)(value:String)(rightWrapper:String): String = {
    leftWrapper + value + rightWrapper
  }
  val wrapWithParens: String => String = wrap("(")(_)(")")
  val wrapWithCustomTag: String => String = wrap ("<html>")(_)("</html>")
  val dupaWrapper: String => String = wrap ("dupa")(_)("dupa")
  println(wrap("*")("text")("*"))
  println(wrapWithParens("text"))
  println(wrapWithCustomTag("text"))
  println(dupaWrapper("text"))

}
