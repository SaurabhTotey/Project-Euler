package problems

import util.Problem

/**
  * A solution to the sixth problem of Project Euler
  */
object Problem6 extends Problem(6) {
    this.outputAnswer(2L * (1L until 100).fold(0L)((sum, i) => sum + ((i + 1) to 100).fold(0L)((innerSum, j) => innerSum + i * j)))
}
