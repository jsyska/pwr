package labs

object Introduction extends App {
  // Declaration and definition of value
  // x is identifier
  // Int is type
  val x: Int = 42
  println(x)

  //Note - type might be omitted, as compiler can infer type
  val y = 33
  println(y)

  // x = 2 - ERROR: vals are immutable
  // functional programming is all about immutability without side effects

  //definition of string
  val aString: String = "Hello string";
  val secondString: String = "New string"

  //other types
  val aBoolean: Boolean = true
  val aChar: Char = '1'
  val aShort: Short = 32767
  val aLong: Long = 2342342342342342L
  val aFloat: Float = 2.0f
  val aDouble: Double = 2.0

  //variables
  var aVariable: Int = 67
  aVariable = 234 //side effect
  //vars are mutable, changing its value is a side effect.

  //below are different kind of expressions, all expressions hold a value
  val x1 = 3 + 4 //expression
  println(x1)
  println(1 + 4 * 3 - 10)
  println(1 == 4)


  println(!(1 == 4))

  var aVariable1 = 3
  aVariable1 += 4
  aVariable1 *= 3

  //instruction (do sth) vs expression (value)

  //if expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 //if is expression - it returns a value
  println(aConditionedValue)

  //loops are discouraged in scala
  var i = 0;
  while (i < 10) {
    println(i)
    i += 1
  } //please do not use it

  //everything in scala is an expression
  val aWeirdValue = aVariable = 3 // Unit === void

  println(aWeirdValue)

  //aVariable = 3 is a side effect and in scala -> side effect is an expression returning Unit

  //for example:
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }

  println()
  //reassigning

  //code blocks - special kind of expressions
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "bye"
  } //code block is an expression

  //instructions are executed, expressions are evaluated
  //functional languages are place where we think more of expressions than of instructions

  //1. difference between "hello" and println("hello")
  //"hello" is a value of type String
  //println("hello") is an expression which is side effect (type is Unit) side effect of println is printing to console
  //2.
  val someValue = {
    2 < 3
  }

  val otherValue = {
    if (someValue) 239 else 98
    43
  }

  def aFunction(a: String, b: Int) =
    a + " " + b

  println(aFunction("asdf", 3))

  def noParamFunc(): Int = 45

  //parameterless functions might be called without parens
  println(noParamFunc())
  println(noParamFunc)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }
  //return type might be omitted, but only in non-recursive functions
  //wont compile: def aRepeatedFunction(aString: String, n: Int) <no type> = {

  println(aRepeatedFunction("A", 3))

  //when you need loops, use recursion


  def aFunctionWithSideEffect(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }
}