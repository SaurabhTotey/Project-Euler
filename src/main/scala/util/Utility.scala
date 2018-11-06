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
      * Determines whether a number is prime or not
      *
      * @param number the number to check the primality of
      * @return whether the given number is prime
      */
    def isPrime(number: Long): Boolean = {
        number == 2 || !(3L to Math.sqrt(number).floor.toLong by 2).exists(i => number % i == 0)
    }

    /**
      * Determines whether the given value string is a palindrome or not (same backwards and forwards)
      *
      * @param value the value to check if it is a palindrome
      * @return whether the given value is a palindrome
      */
    def isPalindrome(value: String): Boolean = {
        (0 to value.length / 2).forall(i => value.charAt(i) == value.charAt(value.length - i - 1))
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
