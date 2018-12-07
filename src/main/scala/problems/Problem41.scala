package problems

import util.{Problem, Utility}

/**
  * A solution to the forty first problem of Project Euler
  */
object Problem41 extends Problem(41) {
    this.outputAnswer((1 to 9).flatMap(i => Utility.permutationsOf(1 to i)).map(permutation => permutation.mkString("").toLong).sorted.reverse.find(number => Utility.isPrime(number)).get)
}
