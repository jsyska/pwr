package labs.lab1

object Factorial extends App{

  def factorial(n:Int, acc: Int): Int = {
    if(n==1) 1 * acc
    else factorial(n-1, acc*n)
  }

  println(factorial(6,1))
}

