public class Main {
  public static void main(String[] args) {
    Sharpie green = new Sharpie("green", 20);
    Sharpie yellow = new Sharpie("yellow", 20);
    Sharpie blue = new Sharpie("blue", 20);
    Sharpie red = new Sharpie("red", 20);
    Sharpie purple = new Sharpie("purple", 20);

    while (yellow.inkAmount != 0) {
      yellow.use();
    }

    SharpieSet set = new SharpieSet();
    set.add(green);
    set.add(yellow);
    set.add(blue);
    set.add(red);
    set.add(purple);

    set.countUsable();
    set.removeTrash();

    for (int i = 0; i < set.list.size(); i++) {
      System.out.println(set.list.get(i).color);
    }
  }
}
