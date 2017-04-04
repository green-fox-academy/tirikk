import java.util.ArrayList;

public class Garden {
  ArrayList<Plant> plants;
  int toWater;

  public void add(Flower flower) {
    plants.add(flower);
  }

  public void add(Tree tree) {
    plants.add(tree);
  }

  public void status() {
    toWater = 0;
    for (Plant plant : plants) {
      if (plant instanceof Flower) {
        if (((Flower) plant).needsWater()) {
          System.out.println("The " + plant.getColor() + " Flower needs water");
          toWater++;
        } else {
          System.out.println("The " + plant.getColor() + " Flower doesn't need water");
        }
      } else {
        if (((Tree) plant).needsWater()) {
          System.out.println("The " + plant.getColor() + " Tree needs water");
          toWater++;
        } else {
          System.out.println("The " + plant.getColor() + " Tree doesn't need water");
        }
      }
    }
  }

  public void water(double i) {
    System.out.println("Watering with " + i);
    for (Plant plant : plants) {
      if (plant instanceof Flower && ((Flower) plant).needsWater()) {
        plant.addWater(i / toWater);
      }
      if (plant instanceof Tree && ((Tree) plant).needsWater()) {
        plant.addWater(i / toWater);
      }
    }
  }

  Garden() {
    plants = new ArrayList<>();
  }
}
