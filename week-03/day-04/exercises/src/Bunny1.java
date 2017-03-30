public class Bunny1 {
  public static void main(String[] args) {
    System.out.println(ears(16));
  }

  public static int ears(int i) {
    if (i == 1) {
      return 2;
    } else {
      return 2 + ears(i - 1);
    }
  }
}
