package problems

import util.Problem

/**
  * A solution to the twenty fourth problem of Project Euler
  */
object Problem24 extends Problem(24) {
    val digits = Array("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
    def makePermutationFromDigits(digits: Array[String]): Array[String] = {
        if (digits.isEmpty) {
            return Array("")
        }
        digits.indices.flatMap(i => makePermutationFromDigits(digits.slice(0, i) ++ digits.slice(i + 1, digits.length)).map(permutation => digits(i) + permutation)).toArray
    }
    this.outputAnswer(makePermutationFromDigits(digits).sorted.apply(1000000 - 1))
}
