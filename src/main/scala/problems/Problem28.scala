package problems

import util.Problem

/**
  * A solution to the twenty eighth problem of Project Euler
  */
object Problem28 extends Problem(28) {
    var skips = -1
    var skipsSinceLastSum = 0
    var sum = 0L
    for (i <- 1 to 1001 * 1001) {
        if ((1 to 1001 by 2).exists(oddNumber => i == oddNumber * oddNumber)) {
            sum += i
            skips += 2
            skipsSinceLastSum = 0
        } else if (skipsSinceLastSum < skips) {
            skipsSinceLastSum += 1
        } else if (skipsSinceLastSum == skips) {
            sum += i
            skipsSinceLastSum = 0
        }
    }
    this.outputAnswer(sum)
}
