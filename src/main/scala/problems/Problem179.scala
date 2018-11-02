package problems

import util.{Problem, Utility}

/**
  * A solution to the hundred seventy ninth problem of Project Euler
  */
object Problem179 extends Problem(179) {
    this.outputAnswer((2 until 10000000).count(i => Utility.factorsOf(i).length == Utility.factorsOf(i + 1).length))
}
