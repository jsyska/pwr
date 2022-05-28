package labs.lab2

object Task3 extends App{
  def length[A](list: List[A], n: Int=0): Int ={
    if(list.isEmpty)  n
    else  length(list.tail, n+1)
  }

  val list = List(1,2,3,4,5)
  println(length(list))

}
