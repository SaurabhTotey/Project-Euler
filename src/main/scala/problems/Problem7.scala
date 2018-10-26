package problems

import util.{NumberGenerator, Problem}

/**
  * A solution to the seventh problem of Project Euler
  */
object Problem7 extends Problem(7) {
    val primeSeq = NumberGenerator.primeSequence()
    primeSeq.generate(10001 - primeSeq.generatedNumbers().length)
    this.outputAnswer(primeSeq.top())
}
