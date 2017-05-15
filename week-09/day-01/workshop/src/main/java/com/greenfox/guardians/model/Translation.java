package com.greenfox.guardians.model;

public class Translation {
  String received;
  String translated = "I am Groot!";

  public Translation() {
  }

  public Translation(String received) {
    this.received = received;
  }

  public String getReceived() {
    return received;
  }

  public String getTranslated() {
    return translated;
  }

  public void setReceived(String received) {
    this.received = received;
  }

  public void setTranslated(String translated) {
    this.translated = translated;
  }
}
