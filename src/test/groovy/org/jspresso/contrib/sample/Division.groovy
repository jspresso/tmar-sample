package org.jspresso.contrib.sample

import org.jspresso.contrib.tmar.core.Tmar4JUnit;
import org.junit.Test;

class Division extends Tmar4JUnit {

  @Test
  void test() {
    eachIteration('test') { tmar ->
      if (tmar.denominator == 0)
        return null;
        
      tmar.quotient = tmar.dividend / tmar.denominator
    }

  }

}
