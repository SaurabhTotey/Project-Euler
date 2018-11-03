package util

import java.io.{File, PrintWriter}

import scala.io.Source
import sys.process._

/**
  * Defines a Project Euler problem
  *
  * @param number the number of the problem
  */
abstract class Problem(val number: Int) extends App {

    //The time when the problem was ran or started
    val startTime = System.currentTimeMillis()
    //The input for this problem
    val input: String = try { Source.fromFile(s"input/Problem${this.number}.txt").mkString } catch { case _: Exception => "" }

    /**
      * Takes a final output and writes it to a file and prints it
      *
      * @param output the final answer for this problem
      */
    def outputAnswer(output: String): Unit = {
        val report = s"Answer: $output\nTime: ${System.currentTimeMillis() - this.startTime}ms"
        println(report)
        val file = new File(s"output/Problem${this.number}.txt")
        if (file.exists()) {
            file.delete()
        }
        file.createNewFile()
        val writer = new PrintWriter(file)
        writer.write(report)
        writer.close()
        s"git add ${file.getPath}".!
        System.exit(0)
    }

    /**
      * Takes a final output and writes it to a file and prints it
      *
      * @param output the final answer for this problem
      */
    def outputAnswer(output: Long): Unit = {
        this.outputAnswer(output.toString)
    }

}
