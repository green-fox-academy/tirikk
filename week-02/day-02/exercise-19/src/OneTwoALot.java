import java.util.Scanner;

public class OneTwoALot {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Specify a number please!");
    int userInput2 = scanner.nextInt();

    if (userInput2 <= 0) {
      System.out.println("Not enough!");
    } else if (userInput2 == 1) {
      System.out.println("One");
    } else if (userInput2 == 2) {
      System.out.println("Two");
    } else {
      System.out.println("A lot");
    }
  }
}
