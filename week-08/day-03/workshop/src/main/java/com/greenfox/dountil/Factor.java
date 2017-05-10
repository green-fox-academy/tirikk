package com.greenfox.dountil;

public class Factor {
  int result;

  public Factor(int i) {
    result = 1;
    for (int j = 1; j <= i; j++) {
      result *= j;
    }
  }

  public int getResult() {
    return result;
  }
}
