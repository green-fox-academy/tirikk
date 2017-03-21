import java.util.Scanner;
public class AnimalsAndLegs {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Write a program that asks for two integers
    // The first represents the number of chickens the farmer has
    // The second represents the number of pigs the farmer has
    // It should print how many legs all the animals have

    System.out.println("How many chickens does the farmer have?");

    int userInput1 = scanner.nextInt();

    System.out.println("How many pigs does the farmer have?");

    int userInput2 = scanner.nextInt();

    int legsTotal = userInput1 * 2 + userInput2 * 4;

    System.out.println("Total number of legs on the farm (besides the farmers): " + legsTotal);

  }
}