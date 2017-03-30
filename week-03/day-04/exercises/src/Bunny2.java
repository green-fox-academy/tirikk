public class Bunny2 {
  public static void main(String[] args) {
    System.out.println(ears(5));
  }

  public static int ears(int n) {
    if (n % 2 == 0) {
      return 3 + ears(n - 1);
    } else {
      if (n == 1) {
        return 2;
      } else {
        return 2 + ears(n - 1);
      }
    }
  }
}
