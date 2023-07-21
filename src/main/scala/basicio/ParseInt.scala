package basicio

import scala.scalanative.unsafe._
import scala.scalanative.libc._
import scala.scalanative.unsafe.Size.intToSize

object ParseInt:
  def main(args: Array[String]): Unit =
    println("ParseInt")
    val line_buffer = stackalloc[Byte](1024.toUSize)
    while (stdio.fgets(line_buffer, 1023, stdio.stdin) != null)
      val int = parseInt(line_buffer)
      println(s"Ohh $int")
    println("Done")

  def parseInt(line: CString): Int =
    val int_pointer: Ptr[Int] = stackalloc[Int]()
    if (stdio.sscanf(line, c"%d\n", int_pointer) == 0)
      throw new Exception("Parse error")
    stdio.printf(c"Read %d at address %p\n", !int_pointer, int_pointer)
    !int_pointer
