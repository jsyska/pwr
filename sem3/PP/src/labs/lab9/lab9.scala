package labs.lab9

import scala.collection.immutable.Queue

object lab9 extends App {

  //Task1

  val nums = List(1,2,3,4)
  val chars = List('a','b','c')
  val colors = List("black", "white")


  val result = for{ n <- nums
       ch <- chars
       co <- colors}
    yield (n + "-" +ch + "-" +co)

  println(result)

  val result2 = nums.flatMap(n => chars.flatMap(ch => colors.map(co => s"$n-"+ ch + "-" +co)))
  println(result2)

  //Task2
  sealed trait BinaryTree[+A]
  case object Empty extends BinaryTree[Nothing]
  case class Node[+A](elem:A, left:BinaryTree[A], right:BinaryTree[A]) extends BinaryTree[A]

  val t = Node(1, Node(2, Node(4,Empty,Node(9, Empty, Empty)),Node(5, Node(10, Empty, Empty),Empty)), Node(3, Node(6, Node(11, Empty, Empty), Empty), Node(7, Empty, Empty)))

  def preOrder[A](binaryTree: BinaryTree[A]): List[A] = {
    def inner[A](tree: BinaryTree[A], res: List[A]): List[A] = {
      tree match {
        case Empty => List()
        case Node(elem,left,right) => res ::: List(elem) ::: preOrder(left) ::: preOrder(right)
      }
    }
    inner(binaryTree,List())
  }

  def inOrder[A](binaryTree: BinaryTree[A]): List[A] = {
    def inner[A](tree: BinaryTree[A], res: List[A]): List[A] = {
      tree match {
        case Empty => List()
        case Node(elem,left,right) => res ::: inOrder(left) ::: List(elem) ::: inOrder(right)
      }
    }
    inner(binaryTree,List())
  }

  def postOrder[A](binaryTree: BinaryTree[A]): List[A] = {
    def inner[A](tree: BinaryTree[A], res: List[A]): List[A] = {
      tree match {
        case Empty => List()
        case Node(elem,left,right) => res ::: postOrder(left) ::: postOrder(right) ::: List(elem)
      }
    }
    inner(binaryTree,List())
  }

  def BFS[A](binaryTree: BinaryTree[A]): List[A] = {
    def inner[A] (acc:List[A], q:Queue[BinaryTree[A]]): List[A] = q match {
      case Queue() => acc //empty case
      case h +: t => h match { //non-empty case for queue
        case Empty => inner(acc,t)
        case Node(elem,left,right) => inner(acc :+ elem, t.enqueue(left).enqueue(right))
      }
    }
    inner(List(),Queue(binaryTree))
  }

  println(preOrder(t))
  println(inOrder(t))
  println(postOrder(t))
  println(BFS(t))
}
