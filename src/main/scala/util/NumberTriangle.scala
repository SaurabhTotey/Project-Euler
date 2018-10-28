package util

import scala.collection.mutable.ArrayBuffer

/**
  * A class that represents a triangle of numbers
  */
final class NumberTriangle extends ArrayBuffer[ArrayBuffer[Long]] {

    /**
      * Adds the given row to the number triangle
      * Ensures that row is valid
      *
      * @param row the row to add to the triangle
      */
    def addRow(row: ArrayBuffer[Long]): Unit = {
        if (this.nonEmpty) {
            assert(row.length == this.last.length + 1)
        }
        this += row
    }

    /**
      * Adds the given amount of rows to the triangle with values of 0
      *
      * @param numberOfRowsToAdd how many rows to add
      */
    def addRows(numberOfRowsToAdd: Int): Unit = {
        if (numberOfRowsToAdd <= 0) {
            return
        }
        if (this.isEmpty) {
            this.addRow(ArrayBuffer(0))
        } else {
            this.addRow(ArrayBuffer((0 until this.last.length + 1).map(_ => 0L): _*))
        }
        this.addRows(numberOfRowsToAdd - 1)
    }

    /**
      * Gets the column positions of the row below the given row at the columns under the given column
      *
      * @param row the row of the current position
      * @param col the column of the current position
      * @return the column positions of the coordinates of the row below the given row
      */
    def colsBelow(row: Int, col: Int): Array[Int] = {
        if (row >= this.length - 1) {
            Array()
        } else {
            Array(col, col + 1)
        }
    }

    /**
      * Gets the column positions of the row above the given row at the columns above the given column
      *
      * @param row the row of the current position
      * @param col the column of the current position
      * @return the column positions of the coordinates of the row above the given row
      */
    def colsAbove(row: Int, col: Int): Array[Int] = {
        if (col == 0) {
            Array(0)
        } else if (col == this(row).length - 1) {
            Array(this(row - 1).length - 1)
        } else {
            Array(col - 1, col)
        }
    }

}
