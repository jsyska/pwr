package labs.lab3

object Task1 extends App{

  def isPalindrome(arr: Array[Char]): Boolean = {
    def reverser(arr: Array[Char], temp: Array[Char] = Array()): Array[Char] = {
      if (arr.isEmpty) temp
      else reverser(arr.tail, arr.head +: temp)
    }
    val reverse = reverser(arr)
    arr.sameElements(reverse)
  }

  val p1 = Array('k','a','j','a','k')
  val p2 = Array('n','e','v','e','r','o','d','d','o','r','e','v','e','n')
  val dupa = Array('d','u','p','a')
  println(isPalindrome(p1))
  println(isPalindrome(p2))
  println(isPalindrome(dupa))
}
