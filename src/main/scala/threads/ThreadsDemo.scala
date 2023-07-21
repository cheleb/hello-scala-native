package threads

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random
import scala.concurrent.Future
import scala.concurrent.duration.Duration
import scala.concurrent.Await

object ThreadsDemo {
  def main(args: Array[String]): Unit =
    Await.result(Future.traverse(Vector.tabulate(100)(_ + 1))(f), Duration.Inf)

  def f(i: Int) = Future {
    Thread.sleep(Random.nextInt(50) + 100)
    println(s"hello $i")
  }
}
