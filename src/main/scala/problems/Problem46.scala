package problems

import util.{NumberGenerator, Problem}

import scala.collection.mutable.ArrayBuffer

/**
  * A solution to the forty sixth problem of Project Euler
  */
object Problem46 extends Problem(46) {
	val squareSeq = new NumberGenerator({ (_, amountOfNumbers) => Math.pow(amountOfNumbers + 1, 2).toLong }, ArrayBuffer(1), -1)
	val primeSeq = NumberGenerator.primeSequence(-1)
	def findFirstCompositeOddThatBreaksGoldbachConjecture(testNumber: Long): Long = {
		squareSeq.generateWhile(() => squareSeq.top() * 2 < testNumber)
		primeSeq.generateWhile(() => primeSeq.top() < testNumber)
		if (primeSeq.generatedNumbers().contains(testNumber) || squareSeq.generatedNumbers().exists(square => primeSeq.generatedNumbers().contains(testNumber - 2 * square))) {
			findFirstCompositeOddThatBreaksGoldbachConjecture(testNumber + 2)
		} else {
			testNumber
		}
	}
	this.outputAnswer(findFirstCompositeOddThatBreaksGoldbachConjecture(9))
}
