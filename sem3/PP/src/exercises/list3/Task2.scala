package exercises.list3

import scala.annotation.tailrec

object Task2 extends App{

  // normal recursion
  def reverseList[A](arr:List[A]):List[A] = arr match {
    case h :: t => reverseList(t) ::: List(h)
    case Nil => Nil
  }
  // tail recursion
  @tailrec
  def reverseList[A](arr:List[A], revList:List[A]):List[A] = arr match {
    case h :: t => reverseList(t,  h :: revList)
    case Nil => revList
  }

  val list = List(1,2,3,4,5,6,7)
  val list2 = List()
  println(reverseList(list))
  println(reverseList(list,list2))

}
