package exercises.list2

object FibonnaciNumber extends App {

  def fibonacciNumber(number: Int): Int ={
    if(number == 0) 0
    else if(number == 1) 1
    else fibonacciNumber(number - 2) + fibonacciNumber(number -1)
  }

  println(fibonacciNumber(5))
}
