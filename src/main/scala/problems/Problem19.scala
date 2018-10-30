package problems

import java.util.{Calendar, GregorianCalendar}

import util.Problem

/**
  * A solution to the nineteenth problem of Project Euler
  */
object Problem19 extends Problem(19) {
    val currentDate = new GregorianCalendar()
    currentDate.set(1901, Calendar.JANUARY, 1)
    val endDate = new GregorianCalendar()
    endDate.set(2000, Calendar.DECEMBER, 31)
    var count = 0
    while (!currentDate.equals(endDate)) {
        if (currentDate.get(Calendar.DAY_OF_MONTH) == 1 && currentDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            count += 1
        }
        currentDate.add(Calendar.DAY_OF_YEAR, 1)
    }
    this.outputAnswer(count)
}
