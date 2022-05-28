package exercises.list2

object CountOccurences extends App {

  def countOccurences(list: List[Int], number : Int): Int ={
    if(list.isEmpty) 0
    else{
      if (list.head == number) 1 + countOccurences(list.tail, number)
      else countOccurences(list.tail, number)
    }
  }
  val list = List(1,1,2,4,5,1,6,7,1)
  println(countOccurences(list,1))
}
