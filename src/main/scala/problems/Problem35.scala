package problems

import util.{NumberGenerator, Problem}

/**
  * A solution to the thirty fifth problem of Project Euler
  */
object Problem35 extends Problem(35) {
    val primeSeq = NumberGenerator.primeSequence()
    primeSeq.generateWhile(() => primeSeq.top() < 1000000)
    def rotationsOf(number: Long): Array[Long] = {
        val stringNum = number.toString
        stringNum.indices.map(i => (stringNum.substring(i, stringNum.length) + stringNum.substring(0, i)).toLong).toArray
    }
    this.outputAnswer(primeSeq.generatedNumbers().count(prime => rotationsOf(prime).forall(rotation => primeSeq.generatedNumbers().contains(rotation))))
}
