package exercises.list3

object Task3 extends App{
  def concat(list1: Array[Int], list2: Array[Int], acc: Array[Int]=Array()): Array[Int] ={
    if(list1.isEmpty && list2.isEmpty) return acc
    if(list1.isEmpty) return concat(list1, list2.tail, acc :+ list2.head)
    if(list2.isEmpty) return concat(list1.tail, list2, acc :+ list1.head)
    else concat(list1.tail, list2.tail, acc :+ list1.head :+ list2.head)
  }
  def printArr(list: Array[Int], separator: String):String = {
    if(list.isEmpty) ""
    else list.head + separator + printArr(list.tail, separator)
  }

  val l1 = Array(1,2,3,4)
  val l2 = Array(5,6,7,8,9,10)
  println(printArr(concat(l1,l2)," "))
}
