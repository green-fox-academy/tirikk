package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Meal {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private
  long id;
  @NotNull
  private String date;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "name")
  private MealType type;
  private String description;
  @NotNull
  private Integer calories;

  public Meal() {
  }

  public Meal(String date, MealType type, String description, Integer calories) {
    this.date = date;
    this.type = type;
    this.description = description;
    this.calories = calories;
  }

  public long getId() {
    return id;
  }

  public String getDate() {
    return date;
  }

  public MealType getType() {
    return type;
  }

  public String getDescription() {
    return description;
  }

  public Integer getCalories() {
    return calories;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setType(MealType type) {
    this.type = type;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCalories(Integer calories) {
    this.calories = calories;
  }
}
