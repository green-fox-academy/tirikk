public class WarApp {
  public static void main(String[] args) {
    Armada a1 = new Armada();
    Armada a2 = new Armada();

    a1.fillArmada();
    a2.fillArmada();

    System.out.println(a1.war(a2));
  }
}
