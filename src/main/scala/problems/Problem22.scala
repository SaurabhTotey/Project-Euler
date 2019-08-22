package problems

import util.Problem

/**
 * A solution to the twenty second problem of Project Euler
 */
object Problem22 extends Problem(22) {
	this.outputAnswer(this.input.substring(1, this.input.length - 1).split("\",\"").sorted.zipWithIndex.map({ case (name, index) => name.map(letter => (letter - 'A' + 1).toLong).sum * (index + 1) }).sum)
}
