package exercises.list7

object Task2 extends App{

  trait Set[A] {

    val size: Int

    def put(value: A):Boolean

    def remove(value: A):Boolean

    def intersection(other: Set[A]):Set[A]

    def union(other: Set[A]):Set[A]

    def difference(other: Set[A]):Set[A]

    def subset(other: Set[A]): Set[A]
  }

}
