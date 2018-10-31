package problems

import util.Problem

/**
  * A solution to the thirtieth problem of Project Euler
  */
object Problem30 extends Problem(30) {
    this.outputAnswer((BigInt(2) to BigInt(999999)).filter(number => number == number.toString.map(digit => Math.pow(digit - '0', 5)).sum).sum.toString)
}
