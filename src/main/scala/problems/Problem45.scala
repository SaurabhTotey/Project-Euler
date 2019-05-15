package problems

import util.{NumberGenerator, Problem}

/**
  * A solution to the forty fifth problem of Project Euler
  */
object Problem45 extends Problem(45) {
	val triangleSeq = NumberGenerator.triangleSequence(-1)
	val pentagonSeq = NumberGenerator.pentagonSequence(-1)
	val hexagonSeq = NumberGenerator.hexagonSequence(-1)
	val hasNotGeneratedMinValue = (sequence: NumberGenerator) => sequence.top() < 40755
	triangleSeq.generateWhile(() => hasNotGeneratedMinValue(triangleSeq))
	pentagonSeq.generateWhile(() => hasNotGeneratedMinValue(pentagonSeq))
	hexagonSeq.generateWhile(() => hasNotGeneratedMinValue(hexagonSeq))
	hexagonSeq.generate()
	hexagonSeq.generateWhile(() => {
		triangleSeq.generateWhile(() => triangleSeq.top() < hexagonSeq.top())
		pentagonSeq.generateWhile(() => pentagonSeq.top() < hexagonSeq.top())
		!triangleSeq.generatedNumbers().contains(hexagonSeq.top()) || !pentagonSeq.generatedNumbers().contains(hexagonSeq.top())
	})
	this.outputAnswer(hexagonSeq.top())
}
