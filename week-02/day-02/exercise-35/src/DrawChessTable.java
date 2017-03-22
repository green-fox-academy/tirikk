import java.util.Collections;
import java.util.Scanner;

public class DrawChessTable {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String lineOdd = String.join("%", Collections.nCopies(5, " "));
    String lineEven = String.join(" ", Collections.nCopies(4, "%"));

    for (int i = 1; i <= 8; i++) {
      if (i % 2 == 0) {
        System.out.println("  " + lineEven);
      } else {
        System.out.println(lineOdd);
      }
    }
  }
}
