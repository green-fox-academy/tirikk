package com.greenfox.dountil;

public class Sum {
  int result;

  public Sum(int i) {
    result = 0;
    for (int j = 1; j <= i; j++) {
      result += j;
    }
  }

  public int getResult() {
    return result;
  }
}
