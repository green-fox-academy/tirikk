public class Summing {
  public static void main(String[] args) {

    int param = 34;
    sum(param);

  }
  public static void sum(int param) {
    int sum = 0;
    for (int i = 1; i <= param; i++) {
      sum = sum + i;
    }
    System.out.println(sum);
  }
}
