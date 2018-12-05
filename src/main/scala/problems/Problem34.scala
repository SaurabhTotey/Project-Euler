package problems

import util.Problem

/**
  * A solution to the thirty fourth problem of Project Euler
  */
object Problem34 extends Problem(34) {
    //Arbitrarily chosen ceiling
    this.outputAnswer((3 to 100000).filter(i => i == i.toString.split("").map(digit => (2 to digit.toInt).product).sum).sum)
}
