package problems

import util.Problem

/**
  * A solution to the ninth problem of Project Euler
  */
object Problem9 extends Problem(9) {
    (1 until 1000).foreach(a =>
        (1 until 1000).foreach(b => {
            val c = Math.sqrt(a * a + b * b)
            if (a + b + c == 1000.0) {
                this.outputAnswer(a * b * c.toLong)
            }
        })
    )
}
