package problems

import util.{NumberGenerator, Problem}

import scala.collection.mutable

/**
  * A solution to the fifth problem of Project Euler
  */
object Problem5 extends Problem(5) {
    val primeSeq = NumberGenerator.primeSequence()
    primeSeq.generateWhile(() => primeSeq.top() < 20)
    val primeCounts = mutable.Map(primeSeq.generatedNumbers().filter(prime => prime < 20).map(prime => (prime, 1)).toMap.toSeq: _*)
    (1L to 20).foreach(component => {
        primeCounts.keys.foreach(prime => {
            var tempComponent = component
            var count = 0
            while (tempComponent % prime == 0) {
                count += 1
                tempComponent /= prime
            }
            primeCounts(prime) = Math.max(count, primeCounts(prime))
        })
    })
    this.outputAnswer(primeCounts.foldRight(1L)((mapEntry, accumulated) => accumulated * Math.pow(mapEntry._1.toDouble, mapEntry._2.toDouble).toLong))
}
