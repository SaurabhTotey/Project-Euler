package problems

import util.Problem

/**
  * A solution to the seventeenth problem of Project Euler
  */
object Problem17 extends Problem(17) {
    def wordForNumber(number: Int): String = {
        val baseNumbers = Array("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
        val baseTens = Array("twen", "thir", "for", "fif", "six", "seven", "eigh", "nine")
        if (number == 1000) {
            "one thousand"
        } else if (number >= 100) {
            val remainder = number % 100
            var stringRepr = baseNumbers(number / 100) + " hundred"
            if (remainder != 0) {
                stringRepr += " and " + wordForNumber(number % 100)
            }
            stringRepr
        } else if (number >= 20) {
            val remainder = number % 10
            var stringRepr = baseTens(number / 10 - 2) + "ty"
            if (remainder != 0) {
                stringRepr += "-" + wordForNumber(remainder)
            }
            stringRepr
        } else {
            baseNumbers(number)
        }
    }
    this.outputAnswer((1 to 1000).map(number => wordForNumber(number)).mkString.count(character => character != ' ' && character != '-'))
}
