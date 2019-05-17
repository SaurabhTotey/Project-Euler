package problems

import util.{Problem, Utility}

/**
  * A solution to the forty seventh problem of Project Euler
  */
object Problem47 extends Problem(47) {
	var i = 5L
	var currentPrimeFactorizations = (2 to 5).map(i => Utility.primeFactorFrequenciesOf(i))
	while (currentPrimeFactorizations.exists(primes => primes.keys.toList.length != 4)) {
		i += 1
		currentPrimeFactorizations = currentPrimeFactorizations.slice(1, 4) ++ IndexedSeq(Utility.primeFactorFrequenciesOf(i))
	}
	this.outputAnswer(i - 3)
}
