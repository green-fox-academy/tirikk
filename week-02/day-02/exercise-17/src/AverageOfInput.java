import java.util.Scanner;
public class AverageOfInput {
  public static void main(String[] args) {
    // Write a program that asks for 5 integers in a row,
    // then it should print the sum and the average of these numbers like:
    //
    // Sum: 22, Average: 4.4
    Scanner scanner = new Scanner(System.in);

    System.out.println("Specify an integer!");
    int userInput1 = scanner.nextInt();

    System.out.println("Specify a second integer!");
    int userInput2 = scanner.nextInt();

    System.out.println("Specify a third integer!");
    int userInput3 = scanner.nextInt();

    System.out.println("Specify a fourth integer!");
    int userInput4 = scanner.nextInt();

    System.out.println("Specify a fifth integer!");
    int userInput5 = scanner.nextInt();

    int sum = userInput1 + userInput2 + userInput3 + userInput4 + userInput5;

    double avg = sum / 5;

    System.out.println("Sum: " + sum + ", Average: " + avg);
  }
}

