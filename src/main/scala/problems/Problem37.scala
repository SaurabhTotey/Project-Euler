package problems

import util.{NumberGenerator, Problem}

/**
 * A solution to the thirty seventh problem of Project Euler
 */
object Problem37 extends Problem(37) {
	val primeSeq = NumberGenerator.primeSequence()
	primeSeq.generateWhile(() => primeSeq.top() < 10)
	var truncatablePrimes = Array[Long]()
	def isTruncatablePrime(number: Long): Boolean = {
		val stringNum = number.toString
		primeSeq.generateWhile(() => primeSeq.top() < number)
		val primes = primeSeq.generatedNumbers()
		(0 until stringNum.length).flatMap(i => Array(stringNum.slice(i, stringNum.length).toLong, stringNum.slice(0, stringNum.length - i).toLong)).forall(number => primes.contains(number))
	}
	while (truncatablePrimes.length < 11) {
		val prime = primeSeq.top()
		primeSeq.generate()
		if (isTruncatablePrime(prime)) {
			truncatablePrimes ++= Array(prime)
		}
	}
	this.outputAnswer(truncatablePrimes.sum)
}
