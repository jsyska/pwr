package labs.lab11

object IntroductionLab11 extends App {

  val option: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(option)

  // WORK with unsafe APIs
  def unsafeMethodCall(): String = null
  //  val result = Some(null) // WRONG
  val result = Option(unsafeMethodCall()) // Some or None
  println(result)

  // chained methods
  def backupMethod(): String = "I'm OK"
  val chainedResult = Option(unsafeMethodCall()).orElse(Option(backupMethod()))
  println(chainedResult)

  // DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("I'm OK")
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterChainedResult)


  // functions on Options
  println(option.isEmpty)
  println(option.get)  // USAFE - DO NOT USE THIS

  // map, flatMap, filter
  println(option.map(_ * 2))
  println(option.filter(x => x > 10))
  println(option.flatMap(x => Option(x * 10)))

}
