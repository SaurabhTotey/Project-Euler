package problems

import util.{NumberGenerator, Problem}

/**
  * A solution to the hundred twelfth problem of Project Euler
  */
object Problem112 extends Problem(112) {
	def isBouncy(number: Long): Boolean = {
		val numberString = number.toString
		numberString.sliding(2).exists(twoChars => twoChars(0) > twoChars(1)) && numberString.sliding(2).exists(twoChars => twoChars(1) > twoChars(0))
	}
	var currentValue = 21780L
	var numberOfBouncies = (21780 * 0.9).toLong
	do {
		currentValue += 1
		if (isBouncy(currentValue)) {
			numberOfBouncies += 1
		}
	} while (numberOfBouncies * 100 != currentValue * 99)
	this.outputAnswer(currentValue)
}
