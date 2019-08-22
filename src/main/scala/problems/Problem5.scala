package problems

import util.{Problem, Utility}

import scala.collection.mutable

/**
 * A solution to the fifth problem of Project Euler
 */
object Problem5 extends Problem(5) {
	val primeFactorization = (2 to 20).foldLeft(new mutable.HashMap[Long, Long]())({ (primeFactorization, i) => {
		val currentPrimeFactorization = Utility.primeFactorFrequenciesOf(i)
		currentPrimeFactorization.keys.foreach(primeFactor => primeFactorization.put(primeFactor, Math.max(primeFactorization.getOrElse(primeFactor, 0L), currentPrimeFactorization(primeFactor))))
		primeFactorization
	} })
	this.outputAnswer(primeFactorization.keys.foldLeft(1L)({ (product, primeFactor) => product * Math.pow(primeFactor, primeFactorization(primeFactor)).toLong }))
}
