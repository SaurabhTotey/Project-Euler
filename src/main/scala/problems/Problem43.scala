package problems

import util.{NumberGenerator, Problem, Utility}

/**
 * A solution to the forty third problem of Project Euler
 */
object Problem43 extends Problem(43) {
	val primeSeq = NumberGenerator.primeSequence()
	primeSeq.generateWhile(() => primeSeq.numbersGenerated < 7)
	val primes = primeSeq.generatedNumbers()
	val pandigitals = Utility.permutationsOf(0 to 9).filter(permutation => permutation(0) != 0).map(permutation => permutation.mkString(""))
	this.outputAnswer(pandigitals.filter(pandigital => (1 to 7).forall(i => pandigital.slice(i, i + 3).toLong % primes(i - 1) == 0)).map(pandigital => pandigital.toLong).sum)
}
