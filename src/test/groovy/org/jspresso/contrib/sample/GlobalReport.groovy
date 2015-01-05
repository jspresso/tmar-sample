package org.jspresso.contrib.sample

import junit.framework.Test
import org.jspresso.contrib.tmar.report.TmarReport


class GlobalReport extends GroovyTestCase {

  void testTmarReport() {
    TmarReport tmarReport = new TmarReport()
    tmarReport.generate()
  }
}

