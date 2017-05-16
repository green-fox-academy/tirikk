package com.greenfox.guardians.model;

public class Food {
  String name;
  int amount;
  int calorie;

  public Food() {
  }

  public String getName() {
    return name;
  }

  public int getAmount() {
    return amount;
  }

  public int getCalorie() {
    return calorie;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public void setCalorie(int calorie) {
    this.calorie = calorie;
  }
}
