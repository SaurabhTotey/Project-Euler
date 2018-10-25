package util

import scala.collection.mutable.ArrayBuffer
import scala.math.BigInt

/**
  * A class that generates numbers given a pattern
  *
  * @param generatorFunction a function that generates a number given the current array of numbers
  * @param storedNumbers the numbers that the util.NumberGenerator starts with and will remember
  * @param forgetfulness Int How many numbers the number generator will store: -1 will store all numbers
  */
class NumberGenerator(private val generatorFunction: Array[BigInt] => BigInt, private val storedNumbers: ArrayBuffer[BigInt], private val forgetfulness: Int = -1) {

    /**
      * @return the first stored number
      */
    def bottom(): BigInt = BigInt(this.storedNumbers(0).bigInteger)

    /**
      * @return the most recently generated number
      */
    def top(): BigInt = BigInt(this.storedNumbers(this.storedNumbers.length - 1).bigInteger)

    /**
      * @return all of the numbers that this number generator have generated
      */
    def generatedNumbers(): Array[BigInt] = {
        this.storedNumbers.map(number => BigInt(number.bigInteger)).toArray
    }

    /**
      * Generates a number for and updates the stored number
      */
    def generate(amountToGenerate: Int = 1): Unit = {
        if (amountToGenerate <= 0) {
            return
        }
        this.storedNumbers.append(this.generatorFunction(this.storedNumbers.toArray))
        while (this.forgetfulness != -1 && this.storedNumbers.size > this.forgetfulness) {
            this.storedNumbers.remove(0)
        }
        this.generate(amountToGenerate - 1)
    }

    /**
      * Takes in a function that evaluates to a boolean, and generates numbers until the evaluator evaluates to false
      *
      * @param evaluator a function that returns whether to continue generating
      */
    def generateWhile(evaluator: () => Boolean) : Unit = {
        while (evaluator()) {
            this.generate()
        }
    }

}

/**
  * A list of default number generators
  */
object NumberGenerator {

    /**
      * Gets a NumberGenerator that generates the Fibonacci sequence
      */
    def fibonaccciSequence(forgetfulness: Int = 2): NumberGenerator = new NumberGenerator({ allNumbers => allNumbers.last + allNumbers(allNumbers.length - 2) }, ArrayBuffer(1, 2), forgetfulness)

    /**
      * Gets a NumberGenerator that generates prime numbers
      */
    def primeSequence(forgetfulness: Int = -1): NumberGenerator = {
        val generatorFunction = if (forgetfulness == -1) {
            { primes: Array[BigInt] =>
                var currentValue = primes.last
                do {
                    currentValue += 2
                } while (primes.exists(prime => currentValue % prime == 0))
                currentValue
            }
        } else {
            { primes: Array[BigInt] =>
                var currentValue = primes.last + 1
                while ((BigInt(2) to currentValue / 2).exists(number => currentValue % number == 0)) {
                    currentValue += 1
                }
                currentValue
            }
        }
        new NumberGenerator(generatorFunction, ArrayBuffer(2, 3), forgetfulness)
    }

}