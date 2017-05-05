package com.greenfox.fox;

import com.greenfox.fox.Enum.Drink;
import com.greenfox.fox.Enum.Food;
import com.greenfox.fox.Enum.Trick;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
  private String image;
  private List<String> actionHistory = new ArrayList<>();
  private boolean vampire;

  public Fox() {
    this.food = Food.STEAK;
    this.drink = Drink.COKE;
    alive = true;
    vampire = false;
    image = "greenfox.png";
    addAction("init", "init");
  }

  public void reset() {
    this.food = Food.STEAK;
    this.drink = Drink.WATER;
    listOfTricks.clear();
    alive = true;
    vampire = false;
    image = "greenfox.png";
    addAction("new", "new");
  }

  public String getName() {
    return name;
  }

  public Food getFood() {
    return food;
  }

  public void setFood(String food) {
    addAction("food", food);
    this.food = Food.valueOf(food.toUpperCase().replace(" ", "_"));
    String[] deadly = {"Rat Poison", "Poisoned Rat", "Air"};
    if (Arrays.asList(deadly).contains(food) && !vampire) {
      die();
    }
    if (vampire && food.equals("Garlic")) {
      die();
    }
  }

  public Drink getDrink() {
    return drink;
  }

  public void setDrink(String drink) {
    addAction("drink", drink);
    this.drink = Drink.valueOf(drink.toUpperCase().replace(" ", "_"));
    String[] deadly = {"Battery Acid", "Antifreeze"};
    if (Arrays.asList(deadly).contains(drink) && !vampire) {
      die();
    } else if (alive && drink.equals("Blood")) {
      turn();
    }
  }

  public List<Trick> getListOfTricks() {
    return listOfTricks;
  }

  public void addTrick(String trick) {
    addAction("trick", trick);
    listOfTricks.add(Trick.valueOf(trick.toUpperCase().replace(" ", "_")));
  }

  public boolean isAlive() {
    return alive;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public List<String> getActionHistory() {
    return actionHistory;
  }

  private void addAction(String type, String value) {
    String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy. MMMM dd. hh:mm:ss"));
    if (type.equals("food") && !value.equals(getFood().toString())) {
      actionHistory.add(time + " : Food has been changed from: " + getFood() + " to: " + value);
    } else if(type.equals("drink") && !value.equals(getDrink().toString())) {
      actionHistory.add(time + " : Drink has been changed from: " + getDrink() + " to: " + value);
    } else if(type.equals("init")) {
      actionHistory.add(time + " : Got a fox");
    } else if(type.equals("new")) {
      actionHistory.add(time + " : Got a new fox");
    } else if(type.equals("trick")) {
      actionHistory.add(time + " : Learned to: " + value);
    }
  }

  private void die() {
    this.alive = false;
    this.image = "greenfox-dead.png";
  }

  private void turn() {
    vampire = true;
    image = "vampire.png";
  }

  public boolean isVampire() {
    return vampire;
  }
}
