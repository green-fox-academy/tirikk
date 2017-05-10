package com.greenfox.arrayhandler;

public class Multiplication {
  int result;

  public Multiplication(int[] i) {
    result = 1;
    for (int j : i) {
      result *= j;
    }
  }

  public int getResult() {
    return result;
  }
}
