public class Power {
  public static void main(String[] args) {
    System.out.println(powerN(2, 10));
  }

  public static int powerN(int i, int n) {
    if (n == 1) {
      return i;
    } else {
      return i * powerN(i, n - 1);
    }
  }
}
