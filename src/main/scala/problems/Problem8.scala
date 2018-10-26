package problems

import util.Problem

/**
  * A solution to the eighth problem of Project Euler
  */
object Problem8 extends Problem(8) {
    val digits = this.input.toCharArray.filter(digit => digit.isDigit).map(digit => (digit - '0').toLong)
    this.outputAnswer((0 until digits.length - 13).map(index => digits.slice(index, index + 13).fold(1L)((product, digit) => product * digit)).max)
}
