import java.util.Scanner;

public class GuessTheNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int randomnumber = (int) (Math.random() * 101);
    System.out.println(randomnumber);

    System.out.println("Guess the stored number (between 0 and 100)!");
    int userInput1 = scanner.nextInt();

    while (userInput1 != randomnumber) {
      if (userInput1 < randomnumber) {
        System.out.println("The stored number is higher!");
      } else {
        System.out.println("The stored number is lower!");
      }
      userInput1 = scanner.nextInt();
    }
    System.out.println("You found the number: " + userInput1);
  }
}
