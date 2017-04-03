public class Main {
  public static void main(String[] args) {
    Animal dog = new Animal();
    System.out.println(dog.hunger);
    dog.play();
    System.out.println(dog.hunger);
    dog.eat();
    System.out.println(dog.hunger);
  }
}
