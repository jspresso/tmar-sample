import org.jspresso.contrib.tmar.report.TmarReport;
class GlobalReport extends GroovyTestCase {
  void "test global report"() {
    new TmarReport().generate()
  }
}