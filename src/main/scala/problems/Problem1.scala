package problems

import util.Problem

/**
  * A solution to the first problem of Project Euler
  */
object Problem1 extends Problem(1) {
    this.outputAnswer((1 until 1000).filter(number => number % 3 == 0 || number % 5 == 0).sum)
}
