package util

import scala.collection.mutable.ArrayBuffer

/**
  * A class that generates numbers given a pattern
  *
  * @param generatorFunction a function that generates a number given the current array of numbers
  * @param storedNumbers the numbers that the util.NumberGenerator starts with and will remember
  * @param forgetfulness Int How many numbers the number generator will store: -1 will store all numbers
  */
final class NumberGenerator(private val generatorFunction: (Array[Long], Int) => Long, private val storedNumbers: ArrayBuffer[Long], private val forgetfulness: Int = -1) {

    /**
      * A read-only property to get how many numbers have been generated
      */
    private[this] var _numbersGenerated: Int = this.storedNumbers.length
    def numbersGenerated: Int = _numbersGenerated
    private def numbersGenerated_=(numGenerated: Int): Unit = { this._numbersGenerated = numGenerated }

    /**
      * @return the first stored number
      */
    def bottom(): Long = this.storedNumbers(0)

    /**
      * @return the most recently generated number
      */
    def top(): Long = this.storedNumbers(this.storedNumbers.length - 1)

    /**
      * @return all of the numbers that this number generator have generated
      */
    def generatedNumbers(): Array[Long] = {
        this.storedNumbers.toArray
    }

    /**
      * Generates a number for and updates the stored number
      */
    def generate(amountToGenerate: Int = 1): Unit = {
        if (amountToGenerate <= 0) {
            return
        }
        this.storedNumbers.append(this.generatorFunction(this.storedNumbers.toArray, this.numbersGenerated))
        this.numbersGenerated += 1
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
    def fibonacciSequence(forgetfulness: Int = 2): NumberGenerator = new NumberGenerator({ (allNumbers, _) => allNumbers.last + allNumbers(allNumbers.length - 2) }, ArrayBuffer(1, 2), forgetfulness)

    /**
      * Gets a NumberGenerator that generates prime numbers
      */
    def primeSequence(forgetfulness: Int = -1): NumberGenerator = {
        val generatorFunction = if (forgetfulness == -1) {
            { (primes: Array[Long], _: Int) =>
                var currentValue = primes.last
                do {
                    currentValue += 2
                } while (primes.exists(prime => currentValue % prime == 0))
                currentValue
            }
        } else {
            { (primes: Array[Long], _: Int) =>
                var currentValue = primes.last + 1
                while ((2L to currentValue / 2).exists(number => currentValue % number == 0)) {
                    currentValue += 1
                }
                currentValue
            }
        }
        new NumberGenerator(generatorFunction, ArrayBuffer(2, 3), forgetfulness)
    }

    /**
      * Gets a NumberGenerator that generates triangle numbers
      */
    def triangleSequence(forgetfulness: Int = 1): NumberGenerator = new NumberGenerator({ (allNumbers, amountOfNumbers) => allNumbers.last + amountOfNumbers + 1 }, ArrayBuffer(1), forgetfulness)

    /**
      * Gets a NumberGenerator that generates a Collatz Sequence
      */
    def collatzSequence(start: Long, forgetfulness: Int = 1): NumberGenerator = new NumberGenerator({ (allNumbers, _) => if (allNumbers.last % 2 == 0) allNumbers.last / 2 else allNumbers.last * 3 + 1}, ArrayBuffer(start), forgetfulness)

}