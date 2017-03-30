public class Counter {
  public static void main(String[] args) {
    counter(10);
  }

  public static void counter(int i) {
    if (i == 1) {
      System.out.println(i);
    } else {
      System.out.println(i);
      counter(i - 1);
    }
  }
}
