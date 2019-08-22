package problems

import util.{Problem, Utility}

/**
 * A solution to the fourth problem of Project Euler
 */
object Problem4 extends Problem(4) {
	var largestPalindrome = 0
	for (i <- 999 to 1 by -1) {
		for (j <- 999 to 1 by -1) {
			if ((i * j) > largestPalindrome && Utility.isPalindrome((i * j).toString)) {
				largestPalindrome = i * j
			}
		}
	}
	this.outputAnswer(largestPalindrome)
}
