package problems

import util.{Problem, Utility}

/**
  * A solution to the twenty fourth problem of Project Euler
  */
object Problem24 extends Problem(24) {
    this.outputAnswer(Utility.permutationsOf(Array("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")).map(permutation => permutation.mkString).sorted.apply(1000000 - 1))
}
