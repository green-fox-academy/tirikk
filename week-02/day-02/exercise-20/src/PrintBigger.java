import java.util.Scanner;

public class PrintBigger {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Specify a number!");
    int userInput1 = scanner.nextInt();

    System.out.println("Specify a second number!");
    int userInput2 = scanner.nextInt();

    if (userInput1 == userInput2) {
      System.out.println("Different numbers please!");
    } else if (userInput1 > userInput2) {
        System.out.println(userInput1);
    } else {
      System.out.println(userInput2);
    }
  }
}
