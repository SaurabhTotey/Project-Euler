package problems

import util.{NumberGenerator, Problem}

/**
  * A solution to the forty second problem of Project Euler
  */
object Problem42 extends Problem(42) {
    val words = this.input.replaceAll("\"", "").split(",")
    val triangleSeq = NumberGenerator.triangleSequence(-1)
    this.outputAnswer(words.count({ word =>
        val wordNumber = word.toCharArray.map(letter => letter - 'A' + 1).sum
        triangleSeq.generateWhile(() => triangleSeq.top() < wordNumber)
        triangleSeq.generatedNumbers().contains(wordNumber)
    }))
}
