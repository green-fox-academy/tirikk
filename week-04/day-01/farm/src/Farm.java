import java.util.ArrayList;

public class Farm {
  ArrayList<Animal> list = new ArrayList<>();
  int slot = 5;

  public void add(Animal animal) {
    list.add(animal);
    slot--;
  }

  public void breed(Animal animal) {
    if (slot > 0) {
      list.add(animal);
      slot--;
    } else {
      System.out.println("There's no room for more animals! (Try slaughtering some...)");
    }
  }

  public void slaughter() {
    Animal leastHungry = new Animal();
    int leastHungryNo = 0;
    for (Animal animal : list) {
      if (animal.hunger < leastHungry.hunger) {
        leastHungry = animal;
        leastHungryNo = list.indexOf(animal);
      }
    }
    list.remove(leastHungryNo);
  }
}
