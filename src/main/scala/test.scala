object test extends App {
  case class Fruit(
    name: String,
    num: Short
  )
  val list = List(
    Fruit("Lemon", 3),
    Fruit("Banana", 3),
    Fruit("Apple", 3),
    Fruit("Lemon", 3)
  )
  println(list)
  val list2: Map[String, List[Fruit]] = list.groupBy(_.name)
  println(list2)
//  val list = List(10, 15, 2, 4, 23, 24, 12)
//  println(list)
//  val list2 = list.groupBy(_ > 10)
//  println(list2)
}
