package exercises.list1

object Practice extends App {

  //Task1
  def HelloWorld(name: Array[String]) ={
    println("Hello World " + name(0))
  }
  val arr : Array[String] =  Array("Kuba","Miki")
  HelloWorld(arr)

  //Task2
  def sumArr(arr: Array[Int]): Int = {
    if(arr.isEmpty) 0
    else arr.head + sumArr(arr.tail)
  }

  val arr2: Array[Int] = Array(1,2,3,4,5)
  println(sumArr(arr2))



}
