import java.util.Collections;
import java.util.Scanner;

public class DrawDiagonal {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Specify a number!");
    int userInput1 = scanner.nextInt();

    for (int i = 1; i <= userInput1; i++) {
      if (i == 1 || i == userInput1) {
        String signs = String.join("", Collections.nCopies(userInput1, "%"));
        System.out.println(signs);
      } else {
        int spcB = i - 2;
        int spcA = userInput1 - 3 - spcB;
        String spacesBefore = String.join("", Collections.nCopies(spcB, " "));
        String spacesAfter = String.join("", Collections.nCopies(spcA, " "));
        System.out.println("%" + spacesBefore + "%" + spacesAfter + "%");
      }
    }
  }
}
