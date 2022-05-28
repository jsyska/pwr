package exercises.list3

import scala.annotation.tailrec


object Task6 extends App{

  @tailrec
  private def isSorted(list: List[Int], previous: Int): Boolean = list match {
    case Nil => true
    case head::tail => if(head < previous) false else isSorted(tail,head)
  }

  def isSorted(list: List[Int]): Boolean = if(list.nonEmpty) isSorted(list, list.head) else true

  val list = List[Int](1,2,3,4,5)
  val listUnsorted = List[Int](1,2,3,5,4)
  println(s"IsSorted: ${isSorted(list)}")
  println(s"Is sorted: ${isSorted(listUnsorted)}")

}
