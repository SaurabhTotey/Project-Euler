package problems

import util.{NumberTriangle, Problem}

import scala.collection.mutable.ArrayBuffer

/**
 * A solution to the sixty-seventh problem of Project Euler
 */
object Problem67 extends Problem(67) {
	val triangle = new NumberTriangle()
	this.input.split("\n").foreach(line => {
		triangle.addRow(ArrayBuffer(line.split(" ").map(number => number.toLong): _*))
	})
	this.outputAnswer(Problem18.getLargestSumOfDownwardPathForTriangle(triangle))
}
