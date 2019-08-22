package problems

import util.{Problem, Utility}

import scala.collection.mutable.ArrayBuffer

/**
 * A solution to the thirty second problem of Project Euler
 */
object Problem32 extends Problem(32) {
	val pandigitals = Utility.permutationsOf("123456789".split(""))
	val products = ArrayBuffer[Long]()
	for (permutation <- pandigitals) {
		for (productLength <- 4 until 6) {
			try {
				val productIndex = permutation.length - productLength
				val product = permutation.slice(productIndex, permutation.length).mkString.toLong
				if (products.contains(product)) {
					throw new Exception("product found; breaking loop because product cannot be added multiple times")
				}
				for (i <- 1 until productIndex) {
					if (permutation.slice(0, i).mkString.toLong * permutation.slice(i, productIndex).mkString.toLong == product) {
						products.append(product)
						throw new Exception("product found; breaking loop because product cannot be added multiple times")
					}
				}
			} catch { case _: Exception => }
		}
	}
	this.outputAnswer(products.sum)
}
