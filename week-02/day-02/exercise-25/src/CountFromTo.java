import java.util.Scanner;

public class CountFromTo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Specify a number!");
    int i = scanner.nextInt();

    System.out.println("Specify a second number!");
    int j = scanner.nextInt();

    if (j <= i) {
      System.out.println("The second number should be higher!");
    } else {
      while (i < j) {
        System.out.println(i);
        i++;
      }
    }
  }
}
