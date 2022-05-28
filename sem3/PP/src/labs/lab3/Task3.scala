package labs.lab3

object Task3 extends App{

  def formatter(format:String) (value: Double): String = {
    format.format(value)
  }

  val normalFormatter: Double => String = formatter("%f")(_)
  val preciseFormatter: Double => String = formatter("%.10f")(_)

  println(normalFormatter(Math.PI))
  println(preciseFormatter(Math.PI))
}
