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

    /**
      * Gets the greatest factor of the given numbers
      * The GCF is the largest factor that divides all the given numbers
      *
      * @param numbers an array of numbers to get the GCF of
      * @return the greatest factor that divides all numbers in the given array
      */
    def greatestCommonFactorOf(numbers: Array[Long]): Long = {
        val factorsOfFirst = this.factorsOf(numbers(0))
        val factorsOfRest = numbers.slice(1, numbers.length).flatMap(number => this.factorsOf(number)).distinct
        factorsOfFirst.reverse.find(factorOfFirst => factorsOfRest.contains(factorOfFirst)).get
    }

    /**
      * Returns whether the given numbers are coprime
      * Numbers are coprime if their GCF is 1
      * If a fraction were to be made with any two of the given numbers, the fraction would not be simplifiable if they were coprime
      *
      * @param numbers an array of numbers to check coprime of
      * @return whether all the given numbers are coprime towards each other
      */
    def isCoprime(numbers: Array[Long]): Boolean = {
        this.greatestCommonFactorOf(numbers) == 1
    }

    /**
      * Gets the lowest common multiple of the given numbers
      * The LCM is the first number that is divisible by all the given numbers
      *
      * @param numbers an array of numbers to get the LCM of
      * @return the lowest common multiple of all the numbers in the given array
      */
    def lowestCommonMultipleOf(numbers: Array[Long]): Long = {
        if (numbers.length <= 1) {
            numbers(0) //This will error on an empty list, but that is desirable
        } else {
            this.lowestCommonMultipleOf(Array(numbers(0) / this.greatestCommonFactorOf(numbers.slice(0, 2)) * numbers(1)) ++ numbers.slice(2, numbers.length))
        }
    }

}
