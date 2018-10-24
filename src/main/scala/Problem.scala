import scala.io.Source

/**
  * Defines a Project Euler problem
  * 
  * @param number the number of the problem
  */
abstract class Problem(val number: Int) extends App {
    val input: String = Source.fromFile(s"input/Problem${this.number}.txt").mkString
}
