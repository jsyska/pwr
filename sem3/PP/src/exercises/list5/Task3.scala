package exercises.list5

object Task3 extends App {

  sealed trait lBT[+A]
  case object LEmpty extends lBT[Nothing]
  case class LNode[+A](elem: A, left:() => lBT[A], right:() => lBT[A]) extends  lBT[A]

  def lTree(n: Int): lBT[Int] ={
    LNode(n,() => lTree(2*n), () => lTree(2*n+1))
  }

  def bfs[A](ltree: lBT[A]):LazyList[A] = {
    def bfsIn(list:List[lBT[A]]):LazyList[A] ={
      list match{
        case Nil => LazyList[A]()
        case LEmpty:: t => bfsIn(t)
        case LNode(value, left, right) :: t => LazyList.cons(value, bfsIn(t ++ List(left(),right())))
      }
    }
    bfsIn(List(ltree))
  }

  def tree(n:Int): LNode[Int] = LNode(n, () => tree(2*n), () => tree(2*n+1))


}
