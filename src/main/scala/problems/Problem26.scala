package problems

import util.Problem

/**
 * A solution to the twenty sixth problem of Project Euler
 */
object Problem26 extends Problem(26) {
	def numberOfRepeatedDigitsFromUnitDivision(denominator: Long, currentNumerator: Long = 1, remainders: Array[Long] = Array()): Long = {
		if (currentNumerator < denominator) {
			return numberOfRepeatedDigitsFromUnitDivision(denominator, currentNumerator * 10, remainders)
		}
		val remainder = currentNumerator % denominator
		if (remainder == 0) {
			return 0
		}
		if (remainders.contains(remainder)) {
			return remainders.length - remainders.lastIndexOf(remainder)
		}
		numberOfRepeatedDigitsFromUnitDivision(denominator, remainder, remainders ++ Array(remainder))
	}
	this.outputAnswer((1 until 1000).maxBy(i => numberOfRepeatedDigitsFromUnitDivision(i)))
}
