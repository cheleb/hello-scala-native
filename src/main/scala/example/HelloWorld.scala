package example

import scala.scalanative.unsafe._
import scala.scalanative.libc._

import sttp.client3.quick._

object Main {

  def main(args: Array[String]): Unit = {

    stdio.printf(c"hello native %s!", c"world")
    println("👍 Hello native %s\n")
    val helloNative = c"Hello native"

    stdio.printf(
      c"%s length at address %p is %d\n",
      helloNative,
      helloNative,
      string.strlen(helloNative)
    )
    stdio.printf(c"sizeOf CString is %d\n", helloNative, sizeof[CString])
    for (offset <- 0 to string.strlen(helloNative).toInt) {
      val c = helloNative(offset)
      val char_adr = helloNative + offset
      stdio.printf(
        c"""The '%c' is %d bit at %p and binary value %d\n""",
        c,
        sizeof[CChar],
        char_adr,
        c
      )
    }
    val resp = quickRequest.get(uri"http://httpbin.org/ip").send(backend)
    println(resp.body)
  }
}
