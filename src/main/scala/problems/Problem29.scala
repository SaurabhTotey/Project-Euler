package problems

import util.Problem

/**
  * A solution to the twenty ninth problem of Project Euler
  */
object Problem29 extends Problem(29) {
    this.outputAnswer((BigInt(2) to BigInt(100)).flatMap(base => (2 to 100).map(exponent => base.pow(exponent))).distinct.length)
}
