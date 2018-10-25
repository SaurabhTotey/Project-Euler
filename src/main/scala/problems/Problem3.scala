package problems

import util.{NumberGenerator, Problem}

/**
  * A solution to the third problem of Project Euler
  */
object Problem3 extends Problem(3) {
    val target = BigInt(this.input)
    val primeGen = NumberGenerator.primeSequence()
    primeGen.generateWhile(() => primeGen.top() <= Math.sqrt(target.toDouble).toLong)
    this.outputAnswer(primeGen.generatedNumbers().reverse.find(prime => target % prime == 0).get.toString)
}
