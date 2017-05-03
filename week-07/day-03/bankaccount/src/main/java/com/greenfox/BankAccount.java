package com.greenfox;

import lombok.Getter;

@Getter
public class BankAccount {
  String name;
  long balance;
  String animalType;
  boolean king;
  boolean badGuy;

  public BankAccount(String name, long balance, String animalType) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.king = false;
    this.badGuy = false;
  }

  public void setKing() {
    king = true;
  }

  public void setBadGuy(boolean badGuy) {
    this.badGuy = badGuy;
  }
}
