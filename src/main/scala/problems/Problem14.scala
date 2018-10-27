package problems

import util.{NumberGenerator, Problem}

/**
  * A solution to the fourteenth problem of Project Euler
  */
object Problem14 extends Problem(14) {
    this.outputAnswer((2 until 1000000).maxBy(start => {
        val collatzSeq = NumberGenerator.collatzSequence(start)
        collatzSeq.generateWhile(() => collatzSeq.top() != 1)
        collatzSeq.numbersGenerated
    }))
}
