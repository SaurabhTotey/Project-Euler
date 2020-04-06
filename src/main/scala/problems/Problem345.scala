package problems

import util.Problem

/**
  * A solution to the three hundred forty fifth problem of Project Euler
  */
object Problem345 extends Problem(345) {
	def getMaxSum(matrix: IndexedSeq[IndexedSeq[Int]]): Int = {
		if (matrix.isEmpty) {
			return 0
		}
		matrix.indices.par.map(i => {
			val matrixWithoutRow = matrix.slice(0, i) ++ matrix.slice(i + 1, matrix.length)
			matrix.indices.par.map(j => {
				val matrixWithoutRowOrCol = matrixWithoutRow.map(row => row.slice(0, j) ++ row.slice(j + 1, row.length))
				matrix(i)(j) + getMaxSum(matrixWithoutRowOrCol)
			}).max
		}).max
	}
	this.outputAnswer(getMaxSum(this.input.split("\n").map(line => line.grouped(4).map(numberString => numberString.stripPrefix(" ").stripPrefix(" ").stripSuffix(" ").toInt).toIndexedSeq).toIndexedSeq))
}
