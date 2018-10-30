package problems

import util.Problem

/**
  * A solution to the twenty fifth problem of Project Euler
  */
object Problem25 extends Problem(25) {
    var first = BigInt(1)
    var second = BigInt(1)
    var index = 2
    while (second.toString.length < 1000) {
        val third = first + second
        first = second
        second = third
        index += 1
    }
    this.outputAnswer(index)
}
