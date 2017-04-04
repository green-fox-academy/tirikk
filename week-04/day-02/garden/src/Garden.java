import java.util.ArrayList;

public class Garden {
  ArrayList<Plant> plants;

  public void add(Flower flower) {
    plants.add(flower);
  }

  public void add(Tree tree) {
    plants.add(tree);
  }

  public void status() {
    for (Plant plant : plants) {
      if (plant instanceof Flower) {
        if (plant.getWater() < 5) {
          System.out.println("The " + plant.getColor() + " Flower needs water");
        } else {
          System.out.println("The " + plant.getColor() + " Flower doesn't need water");
        }
      } else {
        if (plant.getWater() < 5) {
          System.out.println("The " + plant.getColor() + " Tree needs water");
        } else {
          System.out.println("The " + plant.getColor() + " Tree doesn't need water");
        }
      }
    }
  }

  public void water(double i) {
    System.out.println("Watering with " + i);
//    for (Plant plant : plants) {
//      
//    }
  }

  Garden() {
    plants = new ArrayList<>();
  }
}
