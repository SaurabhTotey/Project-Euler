package problems

import util.{NumberTriangle, Problem}

import scala.collection.mutable.ArrayBuffer

/**
  * A solution to the fifty third problem of Project Euler
  */
object Problem53 extends Problem(53) {
	val pascalsTriangle = new NumberTriangle
	(0 to 100).foreach({ i =>
		if (i == 0) {
			pascalsTriangle.addRow(ArrayBuffer(0L))
		} else if (i == 1) {
			pascalsTriangle.addRow(ArrayBuffer(1L, 1L))
		} else {
			val previousRow = pascalsTriangle(i - 1)
			pascalsTriangle.addRow(ArrayBuffer(1L) ++ ArrayBuffer(previousRow.sliding(2).map(l => {
				val sum = l.sum
				if (sum < 0) {
					Long.MaxValue
				} else {
					sum
				}
			}).toSeq: _*) ++ ArrayBuffer(1L))
		}
	})
	this.outputAnswer(pascalsTriangle.flatten.count(number => number > 1000000))
}
