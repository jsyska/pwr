package labs.lab8

abstract class MyAbstractList[+T] {
  def head(): T
  def tail(): MyAbstractList[T]
  def isEmpty(): Boolean
  def add[U >: T](a: U): MyAbstractList[U]
  def print: String
  override def toString: String = "[" + print + "]"
  def foreach(op: T => Unit): Unit
  def filter(pred: T => Boolean): MyAbstractList[T]

  def ++[U >: T](other: MyAbstractList[U]): MyAbstractList[U]
  def map[U >: T](transf: T => U): MyAbstractList[U]
  def flatMap[U](transf: T => MyAbstractList[U]): MyAbstractList[U]

  def insertSort(compare: (T, T) => Int):MyAbstractList[T]
}

case object Empty extends MyAbstractList[Nothing] {
  def head(): Nothing = throw new UnsupportedOperationException
  def tail(): MyAbstractList[Nothing] = throw new UnsupportedOperationException
  def isEmpty(): Boolean = true
  def print: String = ""
  def add[U >: Nothing](a: U): MyAbstractList[U] = new LList(a, Empty)

  override def foreach(op: Nothing => Unit): Unit = ()
  override def filter(pred: Nothing => Boolean): MyAbstractList[Nothing] = Empty
  override def ++[U >: Nothing](other: MyAbstractList[U]): MyAbstractList[U] = other
  override def map[U >: Nothing](transf: Nothing => U): MyAbstractList[U] = Empty
  override def flatMap[U](transf: Nothing => MyAbstractList[U]): MyAbstractList[U] = Empty

  override def insertSort(compare: (Nothing, Nothing) => Int): MyAbstractList[Nothing] = Empty
}
case class LList[+T](h: T, t: MyAbstractList[T]) extends MyAbstractList[T] {
  override def head(): T = h
  override def tail(): MyAbstractList[T] = t
  override def isEmpty(): Boolean = false
  override def print: String = {
    def printHelper(elements: String, list: MyAbstractList[T]): String = {
      if (list.tail.isEmpty()) elements + list.head
      else printHelper(elements + list.head + ",", list.tail)
    }
    printHelper("", this)
  }

  override def add[U >: T](a: U): MyAbstractList[U] = new LList[U](a, this)

  override def foreach(op: T => Unit): Unit = {
    op(head)
    tail.foreach(op)
  }

  override def filter(pred: T => Boolean): MyAbstractList[T] = {
    if(pred(head)) new LList(head, tail.filter(pred))
    else tail.filter(pred)
  }

  def ++[U >: T](other: MyAbstractList[U]): MyAbstractList[U] = {
    new LList(h, t ++ other)
  }

  def map[U >: T](transf: T => U): MyAbstractList[U] = {
    new LList(transf(h), t.map(transf))
  }

  def flatMap[U](transf: T => MyAbstractList[U]): MyAbstractList[U] = {
    transf.apply(h) ++ t.flatMap(transf)
  }

  override def insertSort(compare: (T, T) => Int): MyAbstractList[T] = {
    def insert(x: T, sortedList: MyAbstractList[T]): MyAbstractList[T] = {
      if (sortedList.isEmpty()) LList(x, Empty)
      else if (compare(x, sortedList.head()) <= 0) LList(x, sortedList)
      else LList(sortedList.head, insert(x, sortedList.tail()))
    }
    val sortedTail = t.insertSort(compare)
    insert(h, sortedTail)
  }
}