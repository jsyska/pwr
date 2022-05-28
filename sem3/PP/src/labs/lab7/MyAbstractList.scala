package labs.lab7

abstract class MyAbstractList[+T] {
  /*
     single linked list with int
     head = first element of list
     tail = remainder of the list
     isEmpty
     add(int) new list with added element
     toString - return string representation
   */
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

}

case object Empty extends MyAbstractList[Nothing] {
  def head(): Nothing = throw new UnsupportedOperationException
  def tail(): MyAbstractList[Nothing] = throw new UnsupportedOperationException
  def isEmpty(): Boolean = true
  def print: String = ""

  def add[U >: Nothing](a: U): MyAbstractList[U] = new LList(a, Empty)
  override def foreach(op: Nothing => Unit): Unit = ()
  override def filter(pred: Nothing => Boolean): MyAbstractList[Nothing] = Empty
  override def ++[U >: Nothing](list: MyAbstractList[U]): MyAbstractList[U] = list
  override def map[U](transf: Nothing => U): MyAbstractList[U] = Empty
  override def flatMap[U](transf: Nothing => MyAbstractList[U]): MyAbstractList[U] = Empty

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
    op(h)
    t.foreach(op)
  }

  override def filter(pred: T => Boolean): MyAbstractList[T] = {
    if(pred(h)) LList(h, t.filter(pred))
    else t.filter(pred)
  }

  override def ++[U >: T](other: MyAbstractList[U]): MyAbstractList[U] = new LList[U](h, t ++ other)

  override def map[U >: T](transf: T => U): MyAbstractList[U] = new LList[U](transf(h), t.map(transf))

  override def flatMap[U](transf: T => MyAbstractList[U]): MyAbstractList[U] = transf(h) ++ t.flatMap(transf)
  }