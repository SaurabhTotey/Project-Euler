package util

/**
  * A collection of useful methods
  */
object Utility {

    /**
      * Gets all the factors of the given number
      *
      * @param number the number to get the factors of
      * @return the factors of the given number
      */
    def factorsOf(number: Long): Array[Long] = {
        (1L to Math.sqrt(number).ceil.toLong).filter(smallerNum => number % smallerNum == 0).flatMap(factor => if (number / factor == factor) Array(factor) else Array(factor, number / factor)).toArray
    }

}
