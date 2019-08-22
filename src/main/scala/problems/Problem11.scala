package problems

import util.Problem

/**
 * A solution to the eleventh problem of Project Euler
 */
object Problem11 extends Problem(11) {
	val digits = this.input.split("\n").map(line => line.split(" ").map(digitString => digitString.toLong))
	var largest = 0L
	for (i <- digits.indices) {
		for (j <- digits(i).indices) {
			for (rowChange <- Array(-1, 0, 1)) {
				for (colChange <- Array(-1, 0, 1)) {
					try {
						if (rowChange == colChange && rowChange == 0) {
							throw new Exception()
						}
						var multiple = 1L
						for (k <- 0 until 4) {
							multiple *= digits(i + rowChange * k)(j + colChange * k)
						}
						if (multiple > largest) {
							largest = multiple
						}
					} catch {
						case _: Exception =>
					}
				}
			}
		}
	}
	this.outputAnswer(largest)
}
