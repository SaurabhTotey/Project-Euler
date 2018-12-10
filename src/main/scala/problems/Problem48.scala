package problems

import util.Problem

/**
  * A solution to the forty eighth problem of Project Euler
  */
object Problem48 extends Problem(48) {
    this.outputAnswer((BigInt(1) to BigInt(1000)).map(i => i.pow(i.toInt)).sum.toString.takeRight(10))
}
