package com.greenfox;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class BankAccount {
  String name;
  String balance;
  String animalType;
  boolean king;

  public BankAccount(String name, String balance, String animalType) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.king = false;
  }

  public void setKing() {
    king = true;
  }
}
