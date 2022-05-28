package exercises.list3

import scala.annotation.tailrec

object Task1 extends App{

  @tailrec
  def sumList(list: List[Int], sum: Int=0):Int = {
    if(list.isEmpty) sum;
    else sumList(list.tail,sum + list.head)
  }

  val list = List(1,2,3,4,5)
  println(sumList(list))
}
