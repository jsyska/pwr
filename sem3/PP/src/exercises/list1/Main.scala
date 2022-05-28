package exercises.list1

object Main extends App {
  object MyObject{
    def method()={
      val x=2*5
      x+3}
  }
  println(MyObject.method().getClass)
}