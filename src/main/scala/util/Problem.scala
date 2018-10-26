package util

import java.io.{File, PrintWriter}

import scala.io.Source

/**
  * Defines a Project Euler problem
  *
  * @param number the number of the problem
  */
abstract class Problem(val number: Int) extends App {

    //The input for this problem
    val input: String = try { Source.fromFile(s"input/Problem${this.number}.txt").mkString } catch { case _: Exception => "" }

    /**
      * Takes a final output and writes it to a file and prints it
      *
      * @param output the final answer for this problem
      */
    def outputAnswer(output: String): Unit = {
        println(output)
        val file = new File(s"output/Problem${this.number}.txt")
        if (file.exists()) {
            file.delete()
        }
        file.createNewFile()
        val writer = new PrintWriter(file)
        writer.write(output)
        writer.close()
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
