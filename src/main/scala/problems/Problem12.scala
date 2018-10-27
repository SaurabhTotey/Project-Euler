package problems

import util.{NumberGenerator, Problem}

/**
  * A solution to the twelfth problem of Project Euler
  */
object Problem12 extends Problem(12) {
    val triangleSeq = NumberGenerator.triangleSequence()
    triangleSeq.generateWhile(() => (1L to Math.sqrt(triangleSeq.top()).round + 1).map(possibleFactor => if (triangleSeq.top() % possibleFactor == 0) { if (triangleSeq.top() / possibleFactor == possibleFactor) 1 else 2 } else 0).sum < 500)
    this.outputAnswer(triangleSeq.top())
}
