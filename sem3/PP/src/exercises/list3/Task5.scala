package exercises.list3

object Task5 extends App{

  def splitList(list:List[Int]): (List[Int], List[Int]) = {
    (list.filter(x=>x%2==0), list.filter(x=>x%2!=0))
  }

  def splitList2 (list: List[Int]): (List[Int], List[Int]) = {
    def inSplit (list: List[Int], resA: List[Int], resB: List[Int]): (List[Int], List[Int]) = list match {
      case Nil => (resA, resB)
      case head::tail => if (head%2==0) inSplit(tail, resA:+head,resB) else inSplit(tail,resA,resB:+head)
    }
    inSplit(list,List(),List())
  }

}
