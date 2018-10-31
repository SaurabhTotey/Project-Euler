package util

import scala.reflect.ClassTag

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
        (1L to Math.sqrt(number).floor.toLong).filter(smallerNum => number % smallerNum == 0).flatMap(factor => if (number / factor == factor) Array(factor) else Array(factor, number / factor)).toArray
    }

    /**
      * Gets all the permutations of the given list of objects
      *
      * @param objects The set of items to make the permutations of
      * @return An array of all permutations of the objects array
      */
    def permutationsOf[T: ClassTag](objects: Array[T]): Array[Array[T]] = {
        if (objects.length == 1) {
            return Array(Array(objects(0)))
        }
        objects.indices.flatMap(i => permutationsOf(objects.slice(0, i) ++ objects.slice(i + 1, objects.length)).map(permutation => Array(objects(i)) ++ permutation)).toArray
    }

}
