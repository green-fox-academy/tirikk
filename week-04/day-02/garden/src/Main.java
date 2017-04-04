public class Main {
  public static void main(String[] args) {
    Garden garden = new Garden();

    Flower yellow = new Flower("yellow");
    Flower blue = new Flower("blue");

    Tree purple = new Tree("purple");
    Tree orange = new Tree("orange");

    garden.add(yellow);
    garden.add(blue);
    garden.add(purple);
    garden.add(orange);

    garden.status();

    garden.water(40);
    garden.status();

    garden.water(70);
    garden.status();
  }
}
