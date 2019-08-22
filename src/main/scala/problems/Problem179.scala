package problems

import util.{Problem, Utility}

/**
 * A solution to the hundred seventy ninth problem of Project Euler
 */
object Problem179 extends Problem(179) {
	val factorCounts = (0 to 10000000).map(i => Utility.factorsOf(i).length)
	this.outputAnswer((2 until 10000000).count(i => factorCounts(i) == factorCounts(i + 1)))
}
