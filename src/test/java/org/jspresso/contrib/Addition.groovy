package org.jspresso.contrib

import org.jspresso.contrib.tmar.core.Tmar

class Addition extends Tmar {

  def test() {

    when:
    tmar.c = tmar.a + tmar.b
    if (tmar.c == 36) tmar.c = 35

    then:
    tmar.asserts()

    where:
    tmar << getData('test')
  }
}
