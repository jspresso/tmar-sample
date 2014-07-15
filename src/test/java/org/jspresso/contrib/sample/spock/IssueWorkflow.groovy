package org.jspresso.contrib.sample.spock

import org.jspresso.contrib.sample.Issue
import org.jspresso.contrib.sample.Issue.EState
import org.jspresso.contrib.tmar.core.Tmar

class IssueWorkflow extends Tmar {

  def test() {

    when:
    // Manage your test case
    EState state = tmar.state.toUpperCase();

    // Prepare assertions
    tmar.new = Issue.isAllowed(state, EState.NEW)
    tmar.acknowledged = Issue.isAllowed(state, EState.ACKNOWLEDGED)
    tmar.confirmed = Issue.isAllowed(state, EState.CONFIRMED)
    tmar.assigned = Issue.isAllowed(state, EState.ASSIGNED)
    tmar.frozen = Issue.isAllowed(state, EState.FROZEN)
    tmar.resolved = Issue.isAllowed(state, EState.RESOLVED)
    tmar.feedback = Issue.isAllowed(state, EState.FEEDBACK)
    tmar.closed = Issue.isAllowed(state, EState.CLOSED)

    then:
    tmar.asserts()

    where:
    tmar << getData('test')
  }
}
