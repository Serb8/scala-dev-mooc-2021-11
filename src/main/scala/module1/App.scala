package module1

import scala.concurrent.{Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import scala.util.Random

object App {

  def main(args: Array[String]): Unit = {

    println("starting calculation ...")

    def longRunningComputation(i: Int): Future[Int] = Future {
      Thread.sleep(100)
      i
    }

    val futureList = List(longRunningComputation(1), longRunningComputation(2), longRunningComputation(3))

    println("before onComplete")


    futureList.foreach(f => f.onComplete {
      case Success(value) => println(s"Got the callback, meaning = $value")
      case Failure(e) => e.printStackTrace
    })

    // do the rest of your work
    println("A ..."); Thread.sleep(100)
    println("B ..."); Thread.sleep(100)
    println("C ..."); Thread.sleep(100)
    println("D ..."); Thread.sleep(100)
    println("E ..."); Thread.sleep(100)
    println("F ..."); Thread.sleep(100)
    Thread.sleep(2000)

  }
}
