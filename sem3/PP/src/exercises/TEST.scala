package exercises

case object TEST extends App{
  def get(url: String): String = scala.io.Source.fromURL(url).mkString
  val randomNumber = get("http://www.randomnumberapi.com/api/v1.0/random?min=0&max=1&count=1")
  println("Should I Get additional point?")
  if(randomNumber(1) == '1') println("Yes")
  else println("No")






}
