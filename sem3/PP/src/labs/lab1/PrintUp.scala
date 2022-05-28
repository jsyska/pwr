package labs.lab1

object PrintUp extends App{
  def printUp(n: Int): String ={
    if(n<=100) {
      println(n)
      printUp(n+1)
    } else null
  }
  printUp(1)
}
