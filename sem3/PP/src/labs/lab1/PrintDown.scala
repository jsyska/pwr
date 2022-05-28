package labs.lab1

object PrintDown extends App{
  def printUp(n: Int): String ={
    if(n>0) {
      println(n)
      printUp(n-1)
    } else null
  }
  printUp(100)
}
