package labs.lab12


import scala.collection.mutable
import scala.collection.mutable.Map
import scala.collection.mutable.Set

object Lab12 extends App {

  var SocialNetwork: Map[String, Set[String]] = Map()

  def addPerson(person: String): Unit = SocialNetwork put(person, Set())

  def removePerson(person: String): Unit = {
    if(SocialNetwork.contains(person)){
      SocialNetwork(person).foreach(e => SocialNetwork(e) -= person)
      SocialNetwork remove person
    } else
    println("There is no such a person in the network")
  }

  //def removePerson(person: String):Unit = SocialNetwork = SocialNetwork.filter(network => !network._1.equals(person))

  def friend(person:String, friend: String): Unit = {
    if(SocialNetwork.contains(person) && SocialNetwork.contains(friend)){
      SocialNetwork(person) add friend
      SocialNetwork(friend) add person
    }else
    println("User is not valid")
  }

  def unfriend(person: String, friend: String): Unit = {
    if(SocialNetwork.contains(person) && SocialNetwork.contains(friend)){
      SocialNetwork(person) remove friend
      SocialNetwork(friend) remove person
    } else{
      println("User is not valid")
    }
  }

  def mostPopular(): Unit = {
    val size: Int = SocialNetwork.toSeq.sortBy(_._2.size).reverse(0)._2.size

    print("Most popular people are: ")
    for{
      person <- SocialNetwork
      if person._2.size == size
    } yield print(person._1 + " ")
    println("with the number of friends equal: " + s"$size")
  }

//  def socialConnection(person: String, friend: String): Unit = {
//    def acc(person: String, friend: String, setOfFriends: mutable.Set[String]): Boolean = {
//      if(SocialNetwork(person).contains(friend)) true
//      else if(SocialNetwork(person).forall(person => setOfFriends.contains(person))) false
//      else SocialNetwork(person).diff(setOfFriends).forall(elem => acc(elem, friend, setOfFriends + person))
//    }
//  }

  def socialConnection(person: String, friend: String): Unit = {
    def acc(person: String, friend: String, setOfFriends: mutable.Set[String]): Boolean = {
      if (setOfFriends.contains(friend)) true
      else acc(setOfFriends.head, "friend",setOfFriends.tail)


    }
  }


  addPerson("Kuba")
  addPerson("John")
  addPerson("Drake")
  addPerson("Kate")
  addPerson("Mike")
  addPerson("Jef")
  println(SocialNetwork)
  removePerson("Drake")
  println(SocialNetwork)
  friend("Kuba", "Mike")
  friend("John","Kate")
  println(SocialNetwork)
  unfriend("John", "Kate")
  println(SocialNetwork)
  friend("John","Jef")
  friend("Kuba", "Kate")
  friend("Kate", "John")
  println(SocialNetwork)
  mostPopular()
  println(SocialNetwork)
  println(SocialNetwork)

}
