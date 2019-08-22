package problems

import util.{NumberGenerator, Problem}

/**
 * A solution to the second problem of Project Euler
 */
object Problem2 extends Problem(2) {
	val fibSeq = NumberGenerator.fibonacciSequence(-1)
	fibSeq.generateWhile(() => fibSeq.top() < 4000000)
	this.outputAnswer(fibSeq.generatedNumbers().filter(number => number < 4000000 && number % 2 == 0).sum)
}
