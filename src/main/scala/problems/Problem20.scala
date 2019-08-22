package problems

import util.Problem

/**
 * A solution to the twentieth problem of Project Euler
 */
object Problem20 extends Problem(20) {
	this.outputAnswer((BigInt(1) to BigInt(100)).product.toString().map(digit => digit - '0').sum)
}
