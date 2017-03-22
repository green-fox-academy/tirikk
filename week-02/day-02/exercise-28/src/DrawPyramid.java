import java.util.Collections;
import java.util.Scanner;

public class DrawPyramid {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Specify a number!");
    int userInput1 = scanner.nextInt();

    String str = "*";
    int j = 2 * userInput1;

    for (int i = 1; i <= j; i += 2) {
      int spc = (j - i) / 2;
      String spaces = String.join("", Collections.nCopies(spc, " "));
      String nStr = String.join("", Collections.nCopies(i, str));
      System.out.println(spaces + nStr);
    }
  }
}
