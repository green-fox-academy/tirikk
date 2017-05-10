package com.greenfox.appenda;

public class Append {
  String appended;

  public Append(String appended) {
    this.appended = appended.concat("a");
  }

  public String getAppended() {
    return appended;
  }
}
