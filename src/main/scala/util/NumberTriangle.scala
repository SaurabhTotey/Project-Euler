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
        assert(row.length == this.last.length + 2)
        this += row
    }

    /**
      * Gets the column positions of the row below the given row at the columns under the given column
      *
      * @param row the row of the current position
      * @param col the column of the current position
      * @return the column positions of the coordinates of the row below the given row
      */
    def coordsBelow(row: Int, col: Int): Array[Int] = {
        if (row == this.size - 1) {
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
    def coordsAbove(row: Int, col: Int): Array[Int] = {
        if (col == 0) {
            Array(0)
        } else if (col == this(row).length - 1) {
            Array(this(row - 1).length - 1)
        } else {
            Array(col - 1, col)
        }
    }

}
