package module1
import module1.list.List.{incList, shoutString}



object App {

  def main(args: Array[String]): Unit = {

    println("Option check:")
    val optSome1 = opt.Option.Some(1)
    val optSome2 = opt.Option.Some(8)
    val optSome3 = opt.Option.Some("some_string")
    val optNone = opt.Option.None
    println()

    println("printIfAny")
    optSome1.printIfAny
    optNone.printIfAny
    println()

    println("zip")
    optSome1.zip(optSome2).printIfAny
    optSome1.zip(optSome3).printIfAny
    optSome1.zip(optNone).printIfAny
    println()

    println("filter")
    def isOdd(n: Int): Boolean = if (n%2!=0) true else false
    optSome1.filter(isOdd).printIfAny
    optSome2.filter(isOdd).printIfAny
    optNone.filter(isOdd).printIfAny
    println()

    println("_______________________________________")

    println("List check:")
    val intList = list.List(1, 2, 3, 5, 6)
    val stringList = list.List("a", "b", "c")
    println()

    println("mkString")
    println(intList.mkString(", "))
    println(stringList.mkString(", "))
    println()

    println("::")
    println(intList.::(7).mkString(", "))
    println()

    println("reverse")
    println(intList.reverse().mkString(", "))
    println(stringList.reverse().mkString(", "))
    println()

    println("map")
    println(intList.map(e => e * 2).mkString(", "))
    println()

    println("filter")
    def isEven(n: Int): Boolean = if (n%2==0) true else false
    println(intList.filter(isEven).mkString(", "))
    println()

    println("incList")
    println(incList(intList).mkString(", "))
    println()

    println("shoutString")
    println(shoutString(stringList).mkString(", "))
    println()
  }
}








