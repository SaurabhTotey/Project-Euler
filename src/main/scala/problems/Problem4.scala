package problems

import util.Problem

/**
  * A solution to the fourth problem of Project Euler
  */
object Problem4 extends Problem(4) {
    def isPalindrome(number: Long): Boolean = {
        val stringOfNumber = number.toString
        (0 to stringOfNumber.length / 2).forall(i => stringOfNumber.charAt(i) == stringOfNumber.charAt(stringOfNumber.length - i - 1))
    }
    var largestPalindrome = 0
    for (i <- 999 to 1 by -1) {
        for (j <- 999 to 1 by -1) {
            if ((i * j) > largestPalindrome && isPalindrome(i * j)) {
                largestPalindrome = i * j
            }
        }
    }
    this.outputAnswer(largestPalindrome)
}
