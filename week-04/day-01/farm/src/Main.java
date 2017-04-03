public class Main {
  public static void main(String[] args) {
    Animal pig = new Animal();
    Animal cow = new Animal();
    Animal sheep = new Animal();
    Animal pig2 = new Animal();
    Animal pig3 = new Animal();

    pig3.play();
    pig.eat();

    Farm farm  = new Farm();
    farm.add(pig);
    farm.add(pig2);
    farm.add(pig3);
    farm.add(cow);
    farm.add(sheep);

    System.out.println(farm.list.size());

    farm.breed(pig);

    farm.slaughter();

    System.out.println(farm.list.size());
  }
}
