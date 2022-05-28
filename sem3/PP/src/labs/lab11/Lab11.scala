package labs.lab11

import scala.util.Random

object Lab11 extends App {

  //TASK1

  abstract class MyOption[+T] {
    def map[B](transformer: T => B): MyOption[B]
    def flatMap[B](transformer: T => MyOption[B]): MyOption[B]
    def filter(predicate: T => Boolean): MyOption[T]
  }

  case object MyOptionNone extends MyOption[Nothing] {
    override def map[B](transformer: Nothing => B): MyOption[B] = MyOptionNone
    override def flatMap[B](transformer: Nothing => MyOption[B]): MyOption[B] = MyOptionNone
    override def filter(predicate: Nothing => Boolean): MyOption[Nothing] = MyOptionNone
  }

  case class MyOptionSome[+T](value: T) extends MyOption[T] {

//    override def map[B](transformer: T => B): MyOption[B] = {
//      new MyOptionSome(transformer(value))
//    }

    override def map[B](transformer: T => B): MyOption[B] = MyOptionSome(transformer(value))


//    override def flatMap[B](transformer: T => MyOption[B]): MyOption[B] = this match {
//      case MyOptionSome(value) => transformer(value)
//      case MyOptionSome(null) => MyOptionNone
//    }

    override def flatMap[B](transformer: T => MyOption[B]): MyOption[B] = transformer(value)

    override def filter(predicate: T => Boolean): MyOption[T] = this match {
      case MyOptionSome(value) if predicate(value) => MyOptionSome(value)
      case _ => MyOptionNone
    }
  }

  val option: MyOption[Int] = MyOptionSome(4)
  val option2: MyOption[Int] = MyOptionNone

  println(option)
  println(option2)
  println(option.map(x => x*2))
  println(option2.map(x => x*2))
  println(option.flatMap(x => MyOptionSome(x*2)))
  println(option2.flatMap(x => MyOptionSome(x*2)))
  println(option.filter(x => x > 3))
  println(option2.filter(x => x > 3))

  //TASK 2

  val config: Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

class Connection {
  def connect = "Connected" // connect to some server
}

object Connection {
  val random = new Random(System.nanoTime())

  def apply(host: String, port: String): Option[Connection] =
    if (random.nextBoolean()) Some(new Connection)
    else None
}
// try to establish a connection, if so - print the connect method
val host = config.get("host")
val port = config.get("port")

println()
println("Task 2")

for {
  h <- host
  p <- port
} yield Connection.apply(h, p).map(_.connect).map(println)


}
