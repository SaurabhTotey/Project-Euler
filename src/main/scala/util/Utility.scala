package util

import scala.collection.mutable
import scala.reflect.ClassTag

/**
 * A collection of useful methods
 */
object Utility {

	//A private number generator for use in checking for primality and dealing with primes
	private val primeSeq = NumberGenerator.primeSequence(-1)

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
	 * Gets all the prime factors of the given number and how many of them make up that number
	 *
	 * @param number the number to prime factorize
	 * @return a map where the keys are the prime factors and the values are the frequencies of the corresponding prime factors in making up the given number
	 */
	def primeFactorFrequenciesOf(number: Long): Map[Long, Long] = {
		this.primeSeq.generateWhile(() => this.primeSeq.top() < number)
		var remainingNumber = number
		val primeFrequencies = new mutable.HashMap[Long, Long]()
		var remainingPrimes = this.primeSeq.generatedNumbers()
		while (remainingNumber != 1) {
			while (remainingNumber % remainingPrimes(0) != 0) {
				remainingPrimes = remainingPrimes.slice(1, remainingPrimes.length)
			}
			primeFrequencies.put(remainingPrimes(0), 0)
			while (remainingNumber % remainingPrimes(0) == 0) {
				primeFrequencies.put(remainingPrimes(0), primeFrequencies(remainingPrimes(0)) + 1)
				remainingNumber /= remainingPrimes(0)
			}
		}
		primeFrequencies.toMap
	}

    /**
     * Determines whether a number is prime or not
     *
     * @param number the number to check the primality of
     * @return whether the given number is prime
     */
    def isPrime(number: Long): Boolean = {
		this.primeSeq.generateWhile(() => this.primeSeq.top() < number)
		this.primeSeq.generatedNumbers().contains(number)
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
     * Gets all the permutations of the given indexed sequence of objects
     *
     * @param objects The indexed sequence of items to make the permutations of
     * @return An indexed sequence of all permutations of the objects array
     */
    def permutationsOf[T: ClassTag](objects: IndexedSeq[T]): IndexedSeq[IndexedSeq[T]] = {
        if (objects.length == 1) {
            return IndexedSeq(IndexedSeq(objects(0)))
        }
        objects.indices.flatMap(i => permutationsOf(objects.slice(0, i) ++ objects.slice(i + 1, objects.length)).map(permutation => IndexedSeq(objects(i)) ++ permutation))
    }

    /**
     * Gets the greatest factor of the given numbers
     * The GCF is the largest factor that divides all the given numbers
     *
     * @param numbers an array of numbers to get the GCF of
     * @return the greatest factor that divides all numbers in the given array
     */
    def greatestCommonFactorOf(numbers: IndexedSeq[Long]): Long = {
        val factorsOfFirst = this.factorsOf(numbers(0))
        val factorsOfRest = numbers.slice(1, numbers.length).map(number => this.factorsOf(number))
        factorsOfFirst.sorted.reverse.find(factorOfFirst => factorsOfRest.forall(factors => factors.contains(factorOfFirst))).get
    }

    /**
     * Returns whether the given numbers are coprime
     * Numbers are coprime if their GCF is 1
     * If a fraction were to be made with any two of the given numbers, the fraction would not be simplifiable if they were coprime
     *
     * @param numbers an array of numbers to check coprime of
     * @return whether all the given numbers are coprime towards each other
     */
    def isCoprime(numbers: IndexedSeq[Long]): Boolean = {
        this.greatestCommonFactorOf(numbers) == 1
    }

    /**
     * Gets the lowest common multiple of the given numbers
     * The LCM is the first number that is divisible by all the given numbers
     *
     * @param numbers an array of numbers to get the LCM of
     * @return the lowest common multiple of all the numbers in the given array
     */
    @scala.annotation.tailrec
    def lowestCommonMultipleOf(numbers: IndexedSeq[Long]): Long = {
        if (numbers.length <= 1) {
            numbers(0) //This will error on an empty list, but that is desirable
        } else {
            this.lowestCommonMultipleOf(Array(numbers(0) / this.greatestCommonFactorOf(numbers.slice(0, 2)) * numbers(1)) ++ numbers.slice(2, numbers.length))
        }
    }

}
