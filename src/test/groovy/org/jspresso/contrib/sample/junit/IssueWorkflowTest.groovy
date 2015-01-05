package org.jspresso.contrib.sample.junit

// JUnit
import org.junit.Test
import org.jspresso.contrib.tmar.core.Tmar4JUnit;

// Class to test
import org.jspresso.contrib.sample.Issue
import org.jspresso.contrib.sample.Issue.EState


// test class
class IssueWorkflowTest extends Tmar4JUnit {

  @Test
  void test() {
    eachIteration('test') { tmar ->

      EState state = tmar.state.toUpperCase()
      Issue issue = new Issue()

      tmar.new = issue.isAllowed(state, EState.NEW)
      tmar.acknowledged = issue.isAllowed(state, EState.ACKNOWLEDGED)
      tmar.confirmed = issue.isAllowed(state, EState.CONFIRMED)
      tmar.assigned = issue.isAllowed(state, EState.ASSIGNED)
      tmar.frozen = issue.isAllowed(state, EState.FROZEN)
      tmar.resolved = issue.isAllowed(state, EState.RESOLVED)
      tmar.feedback = issue.isAllowed(state, EState.FEEDBACK)
      tmar.closed = issue.isAllowed(state, EState.CLOSED)

    }
  }
}

