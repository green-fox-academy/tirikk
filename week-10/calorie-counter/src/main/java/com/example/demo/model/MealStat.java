package com.example.demo.model;

public class MealStat {
  private int numberOfMeals;
  private int totalCalories;

  public MealStat(int numberOfMeals, int totalCalories) {
    this.numberOfMeals = numberOfMeals;
    this.totalCalories = totalCalories;
  }

  public int getNumberOfMeals() {
    return numberOfMeals;
  }

  public void setNumberOfMeals(int numberOfMeals) {
    this.numberOfMeals = numberOfMeals;
  }

  public int getTotalCalories() {
    return totalCalories;
  }

  public void setTotalCalories(int totalCalories) {
    this.totalCalories = totalCalories;
  }
}
