package org.jspresso.contrib.sample.junit

import org.jspresso.contrib.tmar.core.Tmar4JUnit;
import org.junit.Test


/**
 * Created by pmb on 29/03/2014.
 */
class CalculatorTest extends Tmar4JUnit {
  
  @Test
  void addition() {
    def testTmar = getData('addition')
    eachIteration(testTmar) { tmar ->
      tmar.results = tmar.op1 + tmar.op2
    }
  }

  @Test
  void multiplication() {
    eachIterationWithIndex('multiplication') { tmar, iterationNumber ->
      tmar.results = tmar.op1 * tmar.op2
    }
  }

}
