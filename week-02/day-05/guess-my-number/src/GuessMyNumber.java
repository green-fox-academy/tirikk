import java.util.Random;
import java.util.Scanner;

public class GuessMyNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("I will think of a number in a range specified by you.\nSpecify the lower bound:");
    int min = scanner.nextInt();
    System.out.println("Now specify the upper bound:");
    int max = scanner.nextInt();
    System.out.println("How many tries would you like?");
    int lives = scanner.nextInt();
    int random = randomGen(min, max);
    System.out.println("\n(" + random + ")");

    System.out.println("I have my number. Guess!");
    for (int i = lives; i > 0; i--) {
      int guess = scanner.nextInt();
      if (guess != random && i == 1) {
        System.out.println("Wrong! You've run out of lives, game over!");
        break;
      } else if (guess == random) {
        System.out.println("Congratulations, you won!");
        break;
      } else if (guess > random) {
        System.out.println("Too high! Guess again! (Lives left: " + (i - 1) + ")");
      } else {
        System.out.println("Too low! Guess again! (Lives left: " + (i - 1) + ")");
      }
    }
  }

  public static int randomGen(int min, int max) {
    Random rand = new Random();
    int number = rand.nextInt((max - min) + 1) + min;
    return number;
  }
}
