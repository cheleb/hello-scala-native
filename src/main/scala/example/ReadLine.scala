package example

import scala.scalanative.unsafe._
import scala.scalanative.libc._
import scala.scalanative.unsafe.Size.intToSize

object ReadLine {
  def main(args: Array[String]): Unit = {
    val word_out_buffer = stackalloc[Byte](32.toUSize)
    stdio.printf(
      c"Allocated %d bytes at %p",
      sizeof[CString].toInt * 32,
      word_out_buffer
    )
    val line_in_buffer = stackalloc[Byte](1024.toUSize)

    while (stdio.fgets(line_in_buffer, 1023, stdio.stdin) != null) {
      parse_line(line_in_buffer, word_out_buffer, 6)
      stdio.printf(c"Parsed: %s\n", word_out_buffer)
    }

    def parse_line(line: CString, word_out: CString, size: Int): Unit = {
      val tmp_buffer = stackalloc[Byte](1024.toUSize)
      val scanfResult = stdio.sscanf(line, c"%1023s\n", tmp_buffer)
      if (scanfResult < 1)
        throw new Exception(s"Bad scanf result $scanfResult")
      val word_len = string.strlen(tmp_buffer)
      if (word_len.toInt > size - 1)
        throw new Exception(s"World should not exeed $size")

      string.strncpy(word_out, tmp_buffer, word_len)

    }
  }
}
