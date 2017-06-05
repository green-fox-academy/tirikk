package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MealType {
  @Id
  String name;

  public MealType() {
  }

  public MealType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
