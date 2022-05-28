package exercises.list2

object RecursiveOddSum extends App {

  def oddSum(list: List[Int]): Int = {
    if(list.isEmpty) 0
    else{
      if (list.head % 2  != 0 ) list.head + oddSum(list.tail)
      else oddSum(list.tail)
    }
  }

  val list = List(1,2,3,4)
  println(oddSum(list))

}
