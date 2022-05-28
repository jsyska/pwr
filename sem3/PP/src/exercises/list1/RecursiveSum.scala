package exercises.list1

object RecursiveSum extends  App {

  def sum(list: List[Int]): Int = {
    if(list.isEmpty) 0
    else list.head + sum(list.tail)
  }

  val list = List(1,2,3,4)
  println(sum(list))

}
