import java.util.Collections;
import java.util.Scanner;

public class DrawSquare {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Specify a number!");
    int userInput1 = scanner.nextInt();

    for (int i = 1; i <= userInput1; i++) {
      if (i == 1 || i == userInput1) {
        System.out.println("%%%%%");
      } else {
        System.out.println("%   %");
      }
    }
  }
}
