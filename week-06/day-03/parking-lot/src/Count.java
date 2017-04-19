import java.util.HashMap;
import java.util.List;

class Count {

  static int countByType(List<Car> cars, CarType type) {
    int number = 0;
    for (Car car : cars) {
      if (car.type == type) {
        number++;
      }
    }
    return number;
  }

  static int countByColor(List<Car> cars, Color color) {
    int number = 0;
    for (Car car : cars) {
      if (car.color == color) {
        number++;
      }
    }
    return number;
  }

  static String countCombinations(List<Car> cars) {
    HashMap<String, Integer> hashMap = new HashMap<>();
    for (CarType type : CarType.values()) {
      for (Color color : Color.values()) {
        for (Car car : cars) {
          if (car.color == color && car.type == type && !hashMap.containsKey(car.color.toString() + car.type.toString
                  ())) {
            int number = 0;
            for (Car vehicle : cars) {
              if ((vehicle.color.toString() + vehicle.type.toString()).equals(car.color.toString() + car.type.toString
                      ())) {
                number++;
              }
            }
            hashMap.put(car.color.toString() + car.type.toString(), number);
          }
        }
      }
    }
    int max = 0;
    String key = "";
    for (String car : hashMap.keySet()) {
      if (hashMap.get(car) > max) {
        max = hashMap.get(car);
        key = car;
      }
    }
    return key + " " + max;
  }
}
