package problems

import util.{NumberGenerator, Problem}

/**
 * A solution to the tenth problem of Project Euler
 */
object Problem10 extends Problem(10) {
	val primeSeq = NumberGenerator.primeSequence()
	primeSeq.generateWhile(() => primeSeq.top() < 2000000)
	this.outputAnswer(primeSeq.generatedNumbers().sum - primeSeq.top())
}
