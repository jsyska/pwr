package labs.lab4

import scala.language.postfixOps

object lab4intro extends App {

  //String operations
  val str: String = "Hi Json"

  println(str.charAt(4))
  println(str.split(" " ).toList)
  //split to list

  //append and prepend
  println('a' +: str)
  println(str.+:('a'))
  println(str :+ 'b')

  //interpolators

  val name = "Chuck"
  val age = 12
  //s-interpolator
  val someString = s"Hi $name I'm $age years old"
  println(someString)

  //f-interpolator
  val someString1 = f"The value of PI is ${Math.PI}%.2f"
  println(someString1)

  //raw-interpolator

  val rawInterpol2 = raw"This is one line \n and this is not second"
  println(rawInterpol2)

  val escaped = raw"This is \n newline"
  println(escaped)

  val butAlso = """This will also escape "quotes" """
  println(butAlso)

  //classes

  object Dog {
    val NUM_OF_LEGS = 4

    def apply(name: String) = {
      println("In apply method")
      new Dog(name, 10)
    }


  }

  abstract class Animal {
    def eat(food: String)
  }

  trait Noisy {
    def makeNoise()
  }

  class Dog(val name: String, val age: Int) extends Animal with Noisy {
    val nameAlias = name
    def bark() = println("Bark bark")
    override def eat(food: String) = println(s"I am a dog and I can eat $food")

    override def makeNoise(): Unit = println("Bark bark")

    def unary_+  = println("used unary+")

    def this() = this("DFSDF", 10)
    def this(name: String) = this(name, 15)
  }

  val dog1 = Dog
  val dog2 = Dog

  val dog3 = new Dog("Pluto", 10)
  val dog4 = Dog("DSFSDFFD")
  val dog5 = new Dog()

  println(dog1)
  println(dog1.apply("asd"))
  println(dog3.nameAlias)
  println(dog3.name)
  println(dog3.bark())
  dog3 bark


  dog3 eat "meat"

  println(dog1)
  println(dog2)
}
