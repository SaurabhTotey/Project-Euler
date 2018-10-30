package problems

import util.{Problem, Utility}

/**
  * A solution to the twenty first problem of Project Euler
  */
object Problem21 extends Problem(21) {
    val factorSums = (0 until 10000).map(number => Utility.factorsOf(number).sum - number)
    var sum = 0L
    for (i <- 1 until 10000) {
        if (factorSums(i) < 10000 && i != factorSums(i) && i == factorSums(factorSums(i).toInt)) {
            sum += i
        }
    }
    this.outputAnswer(sum)
}
