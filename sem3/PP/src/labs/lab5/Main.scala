package labs.lab5

object Main extends App{

  //Task 1
  trait doublerTrait {
    def apply(toDouble: Int):Int
  }
  val doubler = new doublerTrait {
    override def apply(toDouble: Int): Int = toDouble * 2
  }
  println(doubler(4))

  //Task 2
  val  doublerScala = new Function1[Int,Int] {
    override def apply(v1: Int) = v1 * 2
  }
  println(doublerScala(4))

  //Task 3
  val stringConcat = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + " " + v2
  }
  println(stringConcat("Jakub", "Syska"))

  //Task 4

  val curry = new Function1[Int,Int => Int] {
    override def apply(v1: Int): Int => Int = new Function[Int,Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }
  val addTo5 = curry(5)
  println(addTo5(6))

  //Task 5
  val list = List(1,2,3,4,5,6,7,8,9,10)
  println(list)
  val filter = new Function1[Int, Boolean] {
    override def apply(v1: Int): Boolean = (v1 % 3 == 0)
  }
  val divisableBy3 = list.filter(filter)
  //val divisableBy3 = list.filter(_ % 3 == 0)
  println(divisableBy3)
  val mapper = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1*v1*v1;
  }
  val cubed = divisableBy3.map(mapper)
  //val cubed = divisableBy3.map(x => x*x*x)
  println(cubed)

  //Task 6
  def adderCurried(a: Int)(b: Int): Int = a + b

  def toAdderUncurried(intToIntToInt: Int => Int => Int): (Int, Int) => Int = new Function2[Int, Int,Int] {
    override def apply(v1: Int, v2: Int): Int = intToIntToInt(v1)(v2)
  }

  val adderUncurried = toAdderUncurried(adderCurried)
  println(adderUncurried(5,6)) // returns 11


  //Task 7

  def adder(a: Int, b: Int): Int = a + b

  def toAdderCurried(uncurriedAdder: (Int, Int)=>Int) = new Function1[Int, Int=>Int] {
    override def apply(v1: Int): Int=>Int = new Function1[Int, Int] {
      override def apply(v2: Int): Int = uncurriedAdder(v1, v2)
    }
  }

  val adderCurried2 = toAdderCurried(adder)
  println(adderCurried2(5)(6)) // returns 11

}
