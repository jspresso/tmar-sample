package org.jspresso.contrib.sample.spock

import org.jspresso.contrib.sample.Issue
import org.jspresso.contrib.sample.Issue.EState
import org.jspresso.contrib.tmar.core.Tmar
import org.junit.Assert;
import org.junit.Test;

class IssueWorkflowTest extends Tmar {

  @Test
  def test() {
 
    when:
    // Manage your test case
    EState state = tmar.state.toUpperCase();

    // Prepare assertions
    Issue issue = new Issue()
    tmar.new = issue.isAllowed(state, EState.NEW)
    tmar.acknowledged = issue.isAllowed(state, EState.ACKNOWLEDGED)
    tmar.confirmed = issue.isAllowed(state, EState.CONFIRMED)
    tmar.assigned = issue.isAllowed(state, EState.ASSIGNED)
    tmar.frozen = issue.isAllowed(state, EState.FROZEN)
    tmar.resolved = issue.isAllowed(state, EState.RESOLVED)
    tmar.feedback = issue.isAllowed(state, EState.FEEDBACK)
    tmar.closed = issue.isAllowed(state, EState.CLOSED)

    then:
    tmar.asserts()

    where:
    tmar << getData('test')
  }

}
