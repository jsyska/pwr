package labs.lab4

object Lab4 extends App{

  class Counter(value: Int){
    val currentValue = value;

    def getCurrentValue(): Int ={
      return currentValue;
    }

    def increment(): Counter = new Counter(currentValue+1);


    def decrement(): Counter = new Counter(currentValue-1)


    def increment(num: Int): Counter = {
      if(num == 0) new Counter(currentValue)
      else increment.increment(num-1)
    }

    def decrement(num:Int):Counter ={
      if(num ==0) new Counter(currentValue)
      else decrement.decrement(num-1)
    }

    def +(curr: Counter): Counter = {
      new Counter(currentValue + curr.getCurrentValue())
    }

    def -(curr: Counter): Counter = {
       new Counter(currentValue - curr.getCurrentValue())
    }

    def +:(curr: Counter): Counter = {
       new Counter(curr.getCurrentValue() + currentValue)
    }

    def :+(curr: Counter): Counter = {
       new Counter(currentValue + curr.getCurrentValue())
    }

  }

  val test = new Counter(0);
  println(test.currentValue)
  val test2 = new Counter(10)
  val test3 = new Counter(value = 5)
  println((test+test2).currentValue)
  println((test2-test3).currentValue)
  val test4 = test2 :+ test3
  println(test.decrement().currentValue)
  println(test.decrement(10).currentValue)
  println(test3.increment(100).currentValue)
  println(test2.decrement(8).currentValue)
}
