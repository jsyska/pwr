package exercises.list5

object Task2 extends App {
  val fibs: LazyList[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map{ n => n._1 + n._2 }
  //val fibs2: LazyList[Int] = 0 #:: 1 #:: fibs2.zip(fibs2.drop(1)).map(_ + _)
  //val fibs3: LazyList[Int] = 0 #:: 1 #:: fibs3.sliding(2,2).map(_.sum).toLazyList
  fibs.take(5).foreach(println)


  val fib: LazyList[Int] = {
    def fibFrom(a: Int, b: Int): LazyList[Int] = a #:: fibFrom(b, a + b)
    fibFrom(0,1)
  }

  fib.take(5).foreach(println)

}
