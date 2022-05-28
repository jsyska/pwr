package labs.lab3

object Task2 extends App{

  def divide(x:Int) (y:Int): Int = {
    x/y
  }
  val divideBy2: Int => Int = divide(_)(2)
  def add(x:Int)(y:Int) : Int = {
    x + y
  }
  val add5: Int => Int = add(_)(5)
  println(add5.andThen(divideBy2)(20))
  println(add5.compose(divideBy2)(20))
}
