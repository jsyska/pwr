package exercises.list5

object Task1 extends App{

  def lrepeat[A](k:Int, lxs:LazyList[A]):LazyList[A] = {

    def repeat [A](list:LazyList[A], k:Int):LazyList[A] = k match {
      case 0 => LazyList()
      case 1 => list
      case _ => repeat(list.head#::list, k-1)
    }

    lxs match {
      case LazyList() => LazyList()
      case _ => repeat(LazyList(lxs.head),k) #::: lrepeat(k,lxs.tail)
    }
  }

  println(lrepeat(3, LazyList(1,2,3,4)).take(100).toList)
  println(lrepeat(0, LazyList(1,2,3)).take(100).toList)
  println(lrepeat(3, LazyList()).take(100).toList)

}
