package com.greenfox.arrayhandler;

public class Double {
  int[] result;

  public Double(int[] i) {
    result = new int[i.length];
    for (int j = 0; j < i.length; j++) {
      result[j] = i[j] * 2;
    }
  }

  public int[] getResult() {
    return result;
  }
}
