public class Main {
  public static void main(String[] args) {
    Car peugeot = new Car();
    Station omv = new Station();

    omv.refill(peugeot);

    System.out.println(peugeot.gasAmount);
    System.out.println(omv.gasAmount);
  }
}
