abstract class Animal {
  private String name;
  int age;
  String gender;
  boolean hasLegs;

  void greet() {
    System.out.println("Hello");
  }

  abstract String wantChild();

  void eat() {
    System.out.println("Eating...");
  }

  void setName(String name) {
    this.name = name;
  }

  String getName() {
    return name;
  }
}
