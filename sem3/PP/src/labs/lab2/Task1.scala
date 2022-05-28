package labs.lab2

object Task1 extends  App{

  def greaterThan(list: List[Int],n: Int): List[Int] ={
    val accList = List();
    greaterThanHelper(list,n,accList);
  }
 def greaterThanHelper(list: List[Int], n: Int, accList : List[Int]): List[Int] = {
   if(list.length==1){
     if(list.head > n) accList:+n;
     else accList
   }
   else if(list.head > n) greaterThanHelper(list.tail,n,accList:+list.head);
   else greaterThanHelper(list.tail,n,accList);
 }

  val list = List(1,2,3,4,5,6,7,8,9);
  println(greaterThan(list,4))
}

