package problems

import util.Problem

/**
  * A solution to the thirteenth problem of Project Euler
  */
object Problem13 extends Problem(13) {
    this.outputAnswer(this.input.split("\n").map(line => BigInt(line)).sum.toString().substring(0, 10))
}
