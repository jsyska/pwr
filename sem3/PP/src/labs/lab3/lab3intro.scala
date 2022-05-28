package labs.lab3

object lab3intro extends App {

  def func(x: Int, y: Int): Int = {
    x + y
  }

  def funccurry(first: Int)(second: Int):Int = {
    first + second
  }

  def funcwiththree(one: Int)(two: Int)(three: Int) = {
    one + two + three
  }

  val myfunc: (Int, Int) => Int = funcwiththree(_)(_)(10)


  def printer(first: String)(second: String): String = {
    println(first + " " + second)
    "RETURN"
  }

  val printer1: String => String = printer("AAAA")
  val printer2: String => String = printer("BBBB")

  println(printer1("DSFLKSDFS"))
  printer1.andThen(printer2)("ASFAFSAFAFS")
  printer1.compose(printer2)("DSFDSFDF")
  printer1.apply("ONETWOTHREE")

  println(func(10, 20))
  println(funccurry(10)(20))

  val addto10: Int => Int = funccurry(10)
  println(addto10(20))

}


