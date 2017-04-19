import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<Car> cars = new ArrayList<>();

    for (int i = 0; i < 256; i++) {
      cars.add(new Car());
    }

    for (Color color : Color.values()) {
      System.out.println(color + " " + Count.countByColor(cars, color));
    }

    for (CarType type : CarType.values()) {
      System.out.println(type + " " + Count.countByType(cars, type));
    }

    System.out.println("\n" + Count.countCombinations(cars));

  }
}
