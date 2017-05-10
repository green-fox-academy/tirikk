package com.greenfox.arrayhandler;

public class SumArray {
  int result;

  public SumArray(int[] array) {
    result = 0;
    for (int j : array) {
      result += j;
    }
  }

  public int getResult() {
    return result;
  }
}
