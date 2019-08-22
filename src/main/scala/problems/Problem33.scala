package problems

import util.{Problem, Utility}

/**
 * A solution to the thirty third problem of Project Euler
 */
object Problem33 extends Problem(33) {
	var numerators = Array[Int]()
	var denominators = Array[Int]()
	(10 until 100).foreach(denominator => {
		(10 until denominator).foreach(numerator => {
			val numeratorDigits = numerator.toString.split("")
			val denominatorDigits = denominator.toString.split("")
			val commonDigit = numeratorDigits.find(digit => denominatorDigits.contains(digit)).getOrElse("")
			if (commonDigit != "" && commonDigit != "0") {
				val reducedNumerator = numeratorDigits.find(digit => digit != commonDigit).getOrElse(commonDigit).toInt
				val reducedDenominator = denominatorDigits.find(digit => digit != commonDigit).getOrElse(commonDigit).toInt
				if (reducedNumerator != 0 && reducedDenominator != 0) {
					val digitsGCF = Utility.greatestCommonFactorOf(IndexedSeq(reducedNumerator, reducedDenominator))
					val actualGCF = Utility.greatestCommonFactorOf(IndexedSeq(numerator, denominator))
					if (reducedNumerator / digitsGCF == numerator / actualGCF && reducedDenominator / digitsGCF == denominator / actualGCF) {
						numerators ++= Array(numerator)
						denominators ++= Array(denominator)
					}
				}
			}
		})
	})
	val numeratorsMultiple = numerators.product
	val denominatorsMultiple = denominators.product
	val gcf = Utility.greatestCommonFactorOf(IndexedSeq(numeratorsMultiple, denominatorsMultiple))
	this.outputAnswer(denominatorsMultiple / gcf)
}
