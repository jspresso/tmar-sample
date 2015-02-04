import junit.framework.JUnit4TestAdapter;
import junit.framework.*;
import org.junit.runner.*;
public class TmarTestsSuite {

  public static Test suite() {
    TestSuite suite = new TestSuite("Tmar suite");
    suite.addTest(new TestAdapter(org.jspresso.contrib.sample.junit.HashMapTest.class));
    suite.addTest(new TestAdapter(org.jspresso.contrib.sample.spock.PasswordTest.class));
    suite.addTest(new TestAdapter(org.jspresso.contrib.sample.Division.class));
    suite.addTest(new TestAdapter(org.jspresso.contrib.sample.junit.CalculatorTest.class));
    suite.addTest(new TestAdapter(org.jspresso.contrib.sample.junit.IssueWorkflowTest.class));
    suite.addTest(new TestAdapter(org.jspresso.contrib.sample.Weeks.class));
    suite.addTest(new JUnit4TestAdapter(GlobalReport.class));
    return suite;
  }
  
  public static class TestAdapter extends JUnit4TestAdapter {
    private final Runner fRunner;
    public TestAdapter(Class<?> newTestClass) {
      this(newTestClass, JUnit4TestAdapterCache.getDefault());
    }
    public TestAdapter(final Class<?> newTestClass, JUnit4TestAdapterCache cache) {
      super(newTestClass, cache);
      fRunner = Request.classWithoutSuiteMethod(newTestClass).getRunner();
    }
    public Description getDescription() {
      // TIPS : Override to keep @Ignored test
      return fRunner.getDescription();
    }
  }
  public static class TestAdapterFacade implements Test, Describable {
    private final Description fDescription;
    public TestAdapterFacade(String description) {
      fDescription = Description.createSuiteDescription(description);
    }
    public Description getDescription() {
      return fDescription;
    }
    public int countTestCases() {
      return 1;
    }
    public void run(TestResult result) {
    }
  }
}
