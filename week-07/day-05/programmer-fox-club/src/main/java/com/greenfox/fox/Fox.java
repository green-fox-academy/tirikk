package com.greenfox.fox;

import com.greenfox.fox.Enum.Drink;
import com.greenfox.fox.Enum.Food;
import com.greenfox.fox.Enum.Trick;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Fox {
  private String name = "Mr.Fox";
  private Food food;
  private Drink drink;
  private List<Trick> listOfTricks = new ArrayList<>();
  private boolean alive;

  public Fox() {
    this.food = Food.STEAK;
    this.drink = Drink.WATER;
    alive = true;
  }

  public void reset() {
    this.food = Food.STEAK;
    this.drink = Drink.WATER;
    listOfTricks.clear();
    alive = true;
  }

  public String getName() {
    return name;
  }

  public Food getFood() {
    return food;
  }

  public void setFood(String food) {
    this.food = Food.valueOf(food.toUpperCase().replace(" ", "_"));
  }

  public Drink getDrink() {
    return drink;
  }

  public void setDrink(String drink) {
    this.drink = Drink.valueOf(drink.toUpperCase().replace(" ", "_"));
    String[] deadly = {"Battery Acid", "Antifreeze"};
    if (Arrays.asList(deadly).contains(drink)) {
      this.alive = false;
    }
  }

  public List<Trick> getListOfTricks() {
    return listOfTricks;
  }

  public void addTrick(String trick) {
    listOfTricks.add(Trick.valueOf(trick.toUpperCase().replace(" ", "_")));
  }

  public boolean isAlive() {
    return alive;
  }
}
