public class SumDigit {
  public static void main(String [] args) {
    System.out.println(sumdigit(1234));
  }

  public static int sumdigit(int n) {
    if (n < 10) {
      return n % 10;
    } else {
      return n % 10 + sumdigit(n / 10);
    }
  }
}
