import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Car> cars = new ArrayList<>();

    for (int i = 0; i < 256; i++) {
      cars.add(new Car());
    }

    for (Color color : Color.values()) {
      System.out.println(color + " " + countByColor(cars, color));
    }

    for (CarType type : CarType.values()) {
      System.out.println(type + " " + countByType(cars, type));
    }
  }

  public static int countByColor(List<Car> cars, Color color) {
    int number = 0;
    for (Car car : cars) {
      if (car.color == color) {
        number++;
      }
    }
    return number;
  }

  public static int countByType(List<Car> cars, CarType type) {
    int number = 0;
    for (Car car : cars) {
      if (car.type == type) {
        number++;
      }
    }
    return number;
  }
}
