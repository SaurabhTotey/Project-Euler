import scala.collection.mutable

/**
  * A class that generates numbers given a pattern
  *
  * @param generatorFunction a function that generates a number given the current array of numbers
  * @param storedNumbers the numbers that the NumberGenerator starts with and will remember
  * @param forgetfulness Int How many numbers the number generator will store: -1 will store all numbers
  */
class NumberGenerator(private val generatorFunction: Array[Number] => Number, private val storedNumbers: mutable.ArrayBuffer[Number], private val forgetfulness: Int = -1) {

    /**
      * @return the most recently generated number
      */
    def first(): Number = new Number(this.storedNumbers(0))

    /**
      * @return the most recently generated number
      */
    def top(): Number = new Number(this.storedNumbers(this.storedNumbers.length - 1))

    /**
      * @return all of the numbers that this number generator have generated
      */
    def generatedNumbers(): Array[Number] = {
        this.storedNumbers.map(number => new Number(number)).toArray
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
