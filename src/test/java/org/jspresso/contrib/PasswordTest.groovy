package org.jspresso.contrib

import org.jspresso.contrib.tmar.core.Tmar
import org.jspresso.contrib.sample.PasswordChecker

class PasswordTest extends Tmar {

  def test() {
      
          when:
          // Manage your test case
          PasswordChecker pc = new PasswordChecker(tmar.password)
      
          // Prepare assertions
          tmar.a = pc.getA()
          tmar.b = pc.getB()
          tmar.c = pc.getC()
          tmar.d = pc.getD()
          tmar.score = pc.getScore()
          tmar.strength = pc.toString()
      
          then:
          tmar.asserts()
      
          cleanup:
          // Cleanup your data
          // TODO If necessary !
      
          where:
          tmar << getData('test')
        }
}
