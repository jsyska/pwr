package labs.lab2

object Task4 extends App{
  def root3(n: Double, eps: Double = 10e-15, acc:Double=0):Double ={
    if((acc*acc*acc-n).abs <= eps*n.abs)  acc
    else if(acc==0 && n > 1)  root3(n, eps, n/3)
    else if(acc==0 && n <= 1)  root3(n, eps, n)
    else  root3(n, eps, acc + ((n/(acc*acc))-acc)/3)
  }

  println(root3(27).round)

}
