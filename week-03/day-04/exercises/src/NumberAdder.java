public class NumberAdder {
  public static void main(String[] args) {
    System.out.println(numberAdder(15));
  }

  public static int numberAdder(int i) {
    if (i == 1) {
      return 1;
    } else {
      return numberAdder(i - 1) + i;
    }
  }
}
