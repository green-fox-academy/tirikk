import java.util.Collections;
import java.util.Scanner;

public class DrawDiamond {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Specify an odd number!");
    int userInput1 = scanner.nextInt();

    String str = "*";

    if (userInput1 % 2 == 0) {
      System.out.println("Not an odd number!");
    } else {
      for (int i = 1; i <= userInput1; i += 2) {
        int spc = (userInput1 - i) / 2;
        String spaces = String.join("", Collections.nCopies(spc, " "));
        String nStr = String.join("", Collections.nCopies(i, str));
        System.out.println(spaces + nStr);
      }
      for (int i = userInput1 - 2; i > 0; i -= 2) {
        int spc = (userInput1 - i) / 2;
        String spaces = String.join("", Collections.nCopies(spc, " "));
        String nStr = String.join("", Collections.nCopies(i, str));
        System.out.println(spaces + nStr);
      }
    }
  }
}
