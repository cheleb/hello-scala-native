package example

import scala.scalanative.unsafe._
import scala.scalanative.libc._


object Main {


def main(args: Array[String]): Unit = {
    printf(" 👍 Hello native %s\n", "ooooo")
    stdio.printf(c"Hello native %s\n", c"ooooo")
  }
}
