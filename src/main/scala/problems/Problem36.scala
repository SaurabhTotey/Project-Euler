package problems

import util.{Problem, Utility}

/**
  * A solution to the thirty sixth problem of Project Euler
  */
object Problem36 extends Problem(36) {
    this.outputAnswer((1 until 1000000).filter(i => Utility.isPalindrome(i.toString) && Utility.isPalindrome(i.toBinaryString)).sum)
}
