package problems

import util.{Problem, Utility}

/**
  * A solution to the forty ninth problem of Project Euler
  */
object Problem49 extends Problem(49) {
	(1 until 4500).foreach(commonDifference => {
		(1001 to 9999 - commonDifference * 2 by 2).foreach(a1 => {
			val a2 = a1 + commonDifference
			val a3 = a2 + commonDifference
			val a1String = a1.toString
			val a2String = a2.toString
			val a3String = a3.toString
			if (Utility.isPrime(a1) && Utility.isPrime(a2) && Utility.isPrime(a3) && a1.toString.forall(c => a2String.contains(c) && a3String.contains(c)) && a2String.forall(c => a1String.contains(c) && a3String.contains(c)) && a3String.forall(c => a1String.contains(c) && a2String.contains(c))) {
				if (a1 != 1487 && a2 != 4817) {
					this.outputAnswer(s"$a1$a2$a3")
				}
			}
		})
	})
}
