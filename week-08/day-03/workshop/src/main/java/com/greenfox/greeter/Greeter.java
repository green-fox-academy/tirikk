package com.greenfox.greeter;

public class Greeter {
  String welcome_message;

  public Greeter(String name, String title) {
    this.welcome_message = String.format("Oh, hi there %s, my dear %s!", name, title);
  }

  public String getWelcome_message() {
    return welcome_message;
  }
}
