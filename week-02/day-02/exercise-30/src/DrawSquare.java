import java.util.Collections;
import java.util.Scanner;

public class DrawSquare {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Specify a number!");
    int userInput1 = scanner.nextInt();

    for (int i = 1; i <= userInput1; i++) {
      if (i == 1 || i == userInput1) {
        String signs = String.join("", Collections.nCopies(userInput1, "%"));
        System.out.println(signs);
      } else {
        int spc = userInput1 - 2;
        String spaces = String.join("", Collections.nCopies(spc, " "));
        System.out.println("%" + spaces + "%");
      }
    }
  }
}
