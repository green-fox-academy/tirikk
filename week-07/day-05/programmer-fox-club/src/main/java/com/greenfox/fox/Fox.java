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

  public Fox() {
    this.food = Food.STEAK;
    this.drink = Drink.WATER;
    alive = true;
    image = "greenfox.png";
    actionHistory.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy. MMMM dd. hh:mm:ss")) + " : Got a " +
            "fox");
  }

  public void reset() {
    this.food = Food.STEAK;
    this.drink = Drink.WATER;
    listOfTricks.clear();
    alive = true;
    image = "greenfox.png";
    actionHistory.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy. MMMM dd. hh:mm:ss")) + " : Got a " +
            "new" +
            " fox");
  }

  public String getName() {
    return name;
  }

  public Food getFood() {
    return food;
  }

  public void setFood(String food) {
    if (!food.equals(getFood().toString())) {
      actionHistory.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy. MMMM dd. hh:mm:ss")) + " : Food" +
              " has " +

              "been changed from: " + getFood() + " to: " + food);
    }
    this.food = Food.valueOf(food.toUpperCase().replace(" ", "_"));
  }

  public Drink getDrink() {
    return drink;
  }

  public void setDrink(String drink) {
    if (!drink.equals(getDrink().toString())) {
      actionHistory.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy. MMMM dd. hh:mm:ss")) + " : " +
              "Drink has" +
              " " + "been changed from: " + getDrink() + " to: " + drink);
    }
    this.drink = Drink.valueOf(drink.toUpperCase().replace(" ", "_"));
    String[] deadly = {"Battery Acid", "Antifreeze"};
    if (Arrays.asList(deadly).contains(drink)) {
      this.alive = false;
      this.image = "greenfox-dead.png";
    }
  }

  public List<Trick> getListOfTricks() {
    return listOfTricks;
  }

  public void addTrick(String trick) {
    actionHistory.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy. MMMM dd. hh:mm:ss")) + " : " +
            "Learned " +
            "to: " + trick);
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
}
