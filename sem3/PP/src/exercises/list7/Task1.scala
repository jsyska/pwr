package exercises.list7

object Task1 extends App{

  trait Map[K,V] {
    val size: Int

    def put(key: K, value: V): V

    def get(key: K): V

    def remove(key: K): V
  }
}
