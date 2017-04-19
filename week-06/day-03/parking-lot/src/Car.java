public class Car {
  CarType type;
  Color color;

  Car() {
    color = Color.returnColor();
    type = CarType.returnType();
  }
}
