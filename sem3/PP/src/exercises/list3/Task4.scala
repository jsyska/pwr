package exercises.list3

object Task4 extends App{
  def fibonacci(n:Int, acc1: Int, acc2:Int): Int ={
    if(n <= 0) acc2
    else {
      fibonacci(n-1,acc2, acc2+acc1)
    }
  }

  println(fibonacci(6,1,0))
}
