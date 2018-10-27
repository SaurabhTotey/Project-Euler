package problems

import util.Problem

/**
  * A solution to the sixteenth problem of Project Euler
  */
object Problem16 extends Problem(16) {
    this.outputAnswer(BigInt(2).pow(1000).toString.map(digit => digit - '0').sum)
}
