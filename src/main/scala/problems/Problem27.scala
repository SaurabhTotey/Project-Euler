package problems

import util.{NumberGenerator, Problem}

/**
 * A solution to the twenty seventh problem of Project Euler
 */
object Problem27 extends Problem(27) {
	val primeSeq = NumberGenerator.primeSequence()
	primeSeq.generateWhile(() => primeSeq.top() < 1000)
	val generatedPrimes = primeSeq.generatedNumbers().slice(0, primeSeq.numbersGenerated - 1).flatMap(prime => Array(prime, -prime))
	val primeCounts = Array.fill(2 * 1000 * 1000)(0)
	for (a <- -1000 + 1 until 1000) {
		for (b <- generatedPrimes) {
			var n = -1
			var generated = 0L
			do {
				n += 1
				generated = n * n + a * n + b
				primeSeq.generateWhile(() => primeSeq.top() < generated)
			} while (primeSeq.generatedNumbers().contains(generated))
			val index = 1000 * 1000 + a * b.toInt
			primeCounts(index) = Math.max(n - 1, primeCounts(index))
		}
	}
	this.outputAnswer((0 until 2 * 1000 * 1000).maxBy(i => primeCounts(i)) - 1000 * 1000)
}
