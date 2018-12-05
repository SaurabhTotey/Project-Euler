package problems

import util.{NumberGenerator, Problem}

/**
  * A solution to the thirty fourth problem of Project Euler
  */
object Problem34 extends Problem(34) {
    val factorialSeq = NumberGenerator.factorialSequence(10)
    factorialSeq.generate(9)
    val factorials = factorialSeq.generatedNumbers()
    //Arbitrarily chosen ceiling of 100000
    this.outputAnswer((3 to 100000).filter(i => i == i.toString.split("").map(digit => factorials(digit.toInt)).sum).sum)
}
