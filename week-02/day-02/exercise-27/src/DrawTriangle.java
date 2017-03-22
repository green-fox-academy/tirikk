import java.util.Collections;
import java.util.Scanner;

public class DrawTriangle {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Specify a number!");
    int j = scanner.nextInt();

    String str = "*";

    for (int i = 1; i <= j; i++) {
      String nStr = String.join("", Collections.nCopies(i, str));
      System.out.println(nStr);
    }
  }
}
