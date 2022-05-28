package labs.lab6

object Lab6 extends App{
  // Task 1. Write any method that fits into below definitions

  def getMethod1(): (String,String) => Int = (str1 : String, str2) => str1.length + str2.length
  println(getMethod1()("AAA","BBB"))

  def getMethod2(): (Double, String) => String = (value: Double, pattern: String) => value.formatted(pattern)
  println(getMethod2()(Math.PI, "%.6f"))

  def getMethod3(): Int => Int => Int = (v1: Int) => (v2: Int) => v2*v1
  println(getMethod3()(10)(20))

  //Task 2. Write a function that calls a given arithmetic function n times with arg1 and arg2

  val arg1 = 3
  val arg2 = 6

  def add(a:Int, b:Int): Int = a+b
  def multiply(a:Int, b:Int): Int = a*b
  def subtract(a:Int, b:Int): Int = a-b

  def callNTimes(n: Int, f: (Int, Int) => Int): Unit = {
    def innerCall(n: Int, f:(Int,Int) => Int, acc: Int): Unit = {
      if (acc == n) return
      else {
        println(f(arg1, arg2))
        innerCall(n,f,acc+1)
      }
    }
    innerCall(n, f, 0)
  }
  callNTimes(3, add)
  callNTimes(3, multiply)

  // 3. Change the definitions of FunctionXX into lambdas

  def adder(a: Int, b: Int): Int = a + b

  def toAdderCurried1(f: (Int, Int) => Int): Int => Int => Int = (a: Int) => (b: Int) => f(a, b)

  def adderCurried = toAdderCurried1(adder)

  println(adderCurried(1)(2))

  def adderCurried2(a: Int)(b: Int): Int = a + b

  def toAdderUncurried(f: Int => Int => Int): (Int, Int) => Int = (v1: Int, v2: Int) => f(v1)(v2)

  val uncurried = toAdderUncurried(adderCurried2)
  println(uncurried(3, 4))


  //Task 4 Implement a Linked list with basic functionality, the code given below might be helpful
  abstract class MyAbstractList {
    def head(): Int
    def tail(): MyAbstractList
    def isEmpty(): Boolean
    def add(a: Int): MyAbstractList
    def toString(): String
  }

  object Empty extends MyAbstractList {
    override def head(): Int = throw new NoSuchElementException

    override def tail(): MyAbstractList = throw new NoSuchElementException

    override def isEmpty(): Boolean = true

    override def toString: String = "[ ]"//super.toString

    override def add(a: Int): MyAbstractList = new LList(a, Empty)
  }

  class LList(h: Int, t: MyAbstractList) extends MyAbstractList {
    override def head(): Int = h

    override def tail(): MyAbstractList = t

    override def isEmpty(): Boolean = false

    override def add(a: Int): MyAbstractList = new LList(a, this)

    override def toString: String = {
      if (t.isEmpty())
        "" + h
      else
        h + " " + t.toString
    }
  }
  val abstractList = new LList(1, Empty)
  println(abstractList)
  val list2 = abstractList.add(10)
  println(list2)
  val list3 = Empty
  println(list3)
  println(list3.add(4))
  println(list2.add(5))
}
