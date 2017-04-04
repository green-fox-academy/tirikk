public class Main {
  public static void main(String[] args) {

    Carrier c1 = new Carrier(10);
    for (int i = 3; i > 0; i--) {
      c1.addAircraft("F16");
    }
    for (int i = 4; i > 0; i--) {
      c1.addAircraft("F35");
    }

    Carrier c2 = new Carrier(1000);
    for (int i = 5; i > 0; i--) {
      c2.addAircraft("F16");
    }
    for (int i = 2; i > 0; i--) {
      c2.addAircraft("F35");
    }

    c1.getStatus();

    c1.fill();
    c2.fill();

    c1.getStatus();

    c1.fight(c2);

    c1.getStatus();
    c1.fill();

  }
}
