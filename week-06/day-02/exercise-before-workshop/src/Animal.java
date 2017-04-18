abstract class Animal {
  private String name;
  private int age;
  private String gender;
  private boolean hasLegs;

  Animal(String name) {
    this.name = name;
  }

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
