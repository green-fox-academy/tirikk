public abstract class Animal {
  String name;
  int age;
  String gender;
  boolean hasLegs;

  void greet() {
    System.out.println("Hello");
  }

  abstract void wantChild();

  void eat() {
    System.out.println("Eating...");
  }
}
