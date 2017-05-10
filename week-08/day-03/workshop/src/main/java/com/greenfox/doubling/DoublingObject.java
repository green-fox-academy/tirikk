package com.greenfox.doubling;

public class DoublingObject {
  int received;
  int result;

  DoublingObject(int i) {
    received = i;
    result = i * 2;
  }

  public int getReceived() {
    return received;
  }

  public int getResult() {
    return result;
  }
}
