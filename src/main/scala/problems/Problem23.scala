package problems

import util.{Problem, Utility}

/**
 * A solution to the twenty third problem of Project Euler
 */
object Problem23 extends Problem(23) {
	val abundantNumbers = (0 to 28123).filter(i => Utility.factorsOf(i).sum - i - 1 > i)
	val abundantNumberSums = abundantNumbers.flatMap(abundantNum => abundantNumbers.map(number => number + abundantNum)).distinct
	this.outputAnswer((0 to 28123).filter(candidate => !abundantNumberSums.contains(candidate)).sum)
}
