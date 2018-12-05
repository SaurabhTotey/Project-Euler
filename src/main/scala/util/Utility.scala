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
      * Gets the greatest factor of two numbers
      * The GCF is the largest factor that divides two numbers
      *
      * @param num1 the first number to get the GCF with
      * @param num2 the second number to get the GCF with
      * @return the greatest common factor of num1 and num2
      */
    def greatestCommonFactorOf(num1: Long, num2: Long): Long = {
        val factors1 = this.factorsOf(num1)
        val factors2 = this.factorsOf(num2)
        factors1.reverse.find(factor1 => factors2.contains(factor1)).get
    }

    /**
      * Returns whether the given numbers are coprime
      * Numbers are coprime if their GCF is 1
      * If a fraction were to be made with num1 and num2, it would not be simplifiable if they were coprime
      *
      * @param num1 the first number to check coprime of
      * @param num2 the second number to check coprime of
      * @return whether num1 and num2 are coprime towards each other
      */
    def isCoprime(num1: Long, num2: Long): Boolean = {
        this.greatestCommonFactorOf(num1, num2) == 1
    }

    /**
      * Gets the lowest common multiple of two numbers
      * The LCM is the first number that is divisible by the two given numbers
      *
      * @param num1 the first number to get the LCM of
      * @param num2 the second number to get the LCM of
      * @return the lowest common multiple of num1 and num2
      */
    def lowestCommonMultipleOf(num1: Long, num2: Long): Long = {
        num1 / this.greatestCommonFactorOf(num1, num2) * num2
    }

}
