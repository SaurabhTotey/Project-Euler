package problems

import util.{NumberTriangle, Problem}

import scala.collection.mutable.ArrayBuffer

/**
  * A solution to the eighteenth problem of Project Euler
  */
object Problem18 extends Problem(18) {
    val triangle = new NumberTriangle()
    this.input.split("\n").foreach(line => {
        triangle.addRow(ArrayBuffer(line.split(" ").map(number => number.toLong): _*))
    })
    def getLargestSumOfDownwardPathForTriangle(triangle: NumberTriangle): Long = {
        val weightsTriangle = new NumberTriangle()
        weightsTriangle.addRows(triangle.length)
        triangle.indices.foreach(i => weightsTriangle(i) = triangle(i).clone())
        for (row <- weightsTriangle.length - 2 to 0 by -1) {
            for (col <- weightsTriangle(row).indices) {
                weightsTriangle(row)(col) += weightsTriangle.colsBelow(row, col).map(belowCol => weightsTriangle(row + 1)(belowCol)).max
            }
        }
        weightsTriangle(0)(0)
    }
    this.outputAnswer(getLargestSumOfDownwardPathForTriangle(triangle))
}
