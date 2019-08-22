package problems

import util.{NumberGenerator, Problem, Utility}

/**
 * A solution to the twelfth problem of Project Euler
 */
object Problem12 extends Problem(12) {
	val triangleSeq = NumberGenerator.triangleSequence()
	triangleSeq.generateWhile(() => Utility.factorsOf(triangleSeq.top()).length < 500)
	this.outputAnswer(triangleSeq.top())
}
