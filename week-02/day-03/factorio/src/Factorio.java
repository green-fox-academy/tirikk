public class Factorio {
  public static void main(String[] args) {

    double param = 20;
    factorio(param);

  }
  public static void factorio(double param) {
    double factorial = 1;
    for (int i = 1; i <= param; i++) {
      factorial = factorial * i;
    }
    System.out.println(factorial);
  }
}
