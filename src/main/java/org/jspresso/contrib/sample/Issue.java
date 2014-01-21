package org.jspresso.contrib.sample;

import java.util.Arrays;

public class Issue {

  public static enum EState { NEW, ACKNOWLEDGED, CONFIRMED, ASSIGNED, FROZEN, RESOLVED, FEEDBACK, CLOSED }
  
  private EState state;
  
  public Issue() {
    state = EState.NEW;
  }
  
  public void update(EState newState) throws Exception {
    if (!isAllowed(state, newState)) throw new Exception("Transition not allowed");
    this.state = newState;
  }
   
  public static boolean isAllowed(EState state, EState newState) {
    switch (state) {
    case NEW:
      return contains(newState, EState.ACKNOWLEDGED, EState.CONFIRMED, EState.ASSIGNED);
    case ACKNOWLEDGED:
      return contains(newState, EState.ASSIGNED, EState.CONFIRMED);
    case ASSIGNED:
      return contains(newState, EState.CONFIRMED, EState.FROZEN, EState.FEEDBACK, EState.RESOLVED);
    case CONFIRMED:
      return contains(newState, EState.ASSIGNED);
    case FROZEN:
      return contains(newState, EState.ASSIGNED);
    case FEEDBACK:
      return contains(newState, EState.ASSIGNED);
    case RESOLVED:
      return contains(newState, EState.FEEDBACK, EState.CLOSED);
    case CLOSED:
      return contains(newState, EState.FEEDBACK);
    default: 
      return false;
    }
  }
  
  private static boolean contains(EState newState, EState... allowed) {
    return Arrays.asList(allowed).contains(newState);
  }
  
  
}
