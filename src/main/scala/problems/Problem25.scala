package problems

import util.{NumberGenerator, Problem}

/**
  * A solution to the twenty fifth problem of Project Euler
  * TODO: doesn't yet work because I need to upgrade NumberGenerator to allow BigInt because Long can't hold 1000 digit numbers
  */
object Problem25 extends Problem(25) {
    val fibSeq = NumberGenerator.fibonacciSequence()
    fibSeq.generateWhile(() => fibSeq.top().toString.length < 1000)
    this.outputAnswer(fibSeq.numbersGenerated)
}
