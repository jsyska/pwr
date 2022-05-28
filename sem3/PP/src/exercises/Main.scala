package exercises

object Main extends App {
  class Counter(curr: Int) {
    val current = curr

    def currentCount(): Int = {
      return current
    }

    def increment(): Counter = {
      return new Counter(current + 1)
    }

    def decrement(): Counter = {
      return new Counter(current - 1)
    }

    def increment(num: Int): Counter = {
      def incrementHelper(num: Int, result: Counter): Counter = {
        if (num == 0) {
          return result
        }
        incrementHelper(num - 1, new Counter(current + 1))
      }

      return incrementHelper(num, new Counter(current))
    }

    def decrement(num: Int): Counter = {
      return new Counter(current - num)
    }

    def +(): Counter = {
      return new Counter(current + 1)
    }

    def -(): Counter = {
      return new Counter(current - 1)
    }

    def +(curr: Counter): Counter = {
      return new Counter(current + curr.currentCount())
    }

    def -(curr: Counter): Counter = {
      return new Counter(current - curr.currentCount())
    }

    def +:(curr: Counter): Counter = {
      return new Counter(curr.currentCount() + current)
    }

    def :+(curr: Counter): Counter = {
      return new Counter(current + curr.currentCount())
    }
  }
  val test = new Counter(0)
  println(test.currentCount())
  val test2 = test.increment()
  val test3 = test2.+()
  val test4 = test3 + test2
  val test5 = test4 :+ test2
  val test6 = test5 +: test2
  val test7 = test6 - test5
  println(test7.currentCount())

}