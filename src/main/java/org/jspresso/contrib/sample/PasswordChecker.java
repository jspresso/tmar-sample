package org.jspresso.contrib.sample;

public class PasswordChecker {

  private boolean a=false, b=false, c=false, d=false;

  public PasswordChecker(String password) {
    init(password);
  }

  private void init(String password) {

		// Rule A : Has more than 8 characters
    a = password.length()>8;

		// Rule B : Contains both small and uppercase letters
    boolean upper = false;
    boolean lower = false;
    for (char ch : password.toCharArray()) {
      if (Character.isUpperCase(ch)) upper = true;
      if (Character.isLowerCase(ch)) lower = true;
    }
    b = upper && lower;
        
		// Rule C : Contains at least one numerical character 
    for (char ch : password.toCharArray()) {
      if (Character.isDigit(ch)) {
        c = true;
        break;
      }
    }
    
		// Rule D : Contains special characters (~!@#$%^&*_-+='\(){}:;"'<>,.?/ etc.) 
    for (char ch : password.toCharArray()) {
      if (!Character.isLetterOrDigit(ch)) {
        d = true;
        break;
      }
    }
	}

  public int getScore() {
    int i = 0;
    if (a) i++;
    if (b) i++;
    if (c) i++;
    if (d) i++;
    return i;
  }

  @Override
  public String toString() {
    switch (getScore()) {
      case 0:
      case 1:
        return "weak";
      case 2:
        return "fair";
      case 3:
        return "good";
      case 4:
        return "strong";
      default:
        return "error";
    }
  }
  
  public boolean getA() {
    return a;
  }
  
  public boolean getB() {
    return b;
  }
  
  public boolean getC() {
    return c;
  }
  
  public boolean getD() {
    return d;
  }  
  
}
