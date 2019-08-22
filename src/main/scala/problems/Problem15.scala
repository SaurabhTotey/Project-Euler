package problems

import util.Problem

import scala.collection.mutable.ArrayBuffer

/**
 * A solution to the fifteenth problem of Project Euler
 */
object Problem15 extends Problem(15) {
	val tileNumberOfPaths = ArrayBuffer.fill(21)(ArrayBuffer.fill(21)(0))
	(0 until 20).foreach(i => {
		tileNumberOfPaths(20)(i) = 1
		tileNumberOfPaths(i)(20) = 1
	})
	for (row <- 19 to 0 by -1) {
		for (col <- 19 to 0 by -1) {
			tileNumberOfPaths(row)(col) = tileNumberOfPaths(row + 1)(col) + tileNumberOfPaths(row)(col + 1)
		}
	}
	this.outputAnswer(tileNumberOfPaths.flatten.sum)
}
