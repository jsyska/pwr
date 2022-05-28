package labs.lab5

object lab5intro extends App {

  //Anonymous classes
  trait Greeter {
    def sayHi: Unit
  }

  class Person(name: String) extends Greeter {
    override def sayHi: Unit = s"Hi, I'm $name"
    def printName: Unit = println(name)
  }

  val person1 = new Person("Pioter")

  val person2 = new Person("Anonymous") {
    override def sayHi: Unit = "I don't greet strangers"
  }

  person1.sayHi
  person2.sayHi

  println(person1.getClass)
  println(person2.getClass)

  class MyFunction {
    def apply() = println("In function apply")
  }

  val func1 = new MyFunction
  func1()

  class MyBetterFunction {
    def apply(a: Int, b: Int): Int = a + b
  }

  val adder = new MyBetterFunction

  println(adder(3, 4))

  trait MyFunctionTrait {
    def apply(element1: Int, element2: Int): Int
  }

  val adder1 = new MyFunctionTrait {
    override def apply(element1: Int, element2: Int): Int = element1 + element2
  }

  adder1(3, 4)
  trait MyFunctionTraitGeneric[E1, E2, R] {
    def apply(element1: E1, element2: E2): R
  }

  val adder2 = new MyFunctionTraitGeneric[Int, Int, Int] {
    override def apply(element1: Int, element2: Int): Int = element1 + element2
  }

  /// END OF PART 1









  val adderScalaLike = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  adderScalaLike(3,5)

  val addto5 = new Function1[Int, Int] {
    override def apply(v1: Int): Int = 5 + v1
  }

  addto5(10)


}
