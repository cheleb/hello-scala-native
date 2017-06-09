package example

import model.Person

object Main {
  def main(args: Array[String]): Unit = {
    val zozo = Person ("zozo")
    println(s"Hello, wonderful world from $zozo!")
    val test = "oo"
    println(test.length)
  }
}
