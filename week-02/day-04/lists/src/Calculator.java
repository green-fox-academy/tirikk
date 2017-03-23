import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
  public static void main(String... args) {
    Scanner scanner = new Scanner(System.in);

    // Create a simple calculator application which reads the parameters from the prompt
    // and prints the result to the prompt.
    // It should support the following operations:
    // +, -, *, /, % and it should support two operands.
    // The format of the expressions must be: {operation} {operand} {operand}.
    // Examples: "+ 3 3" (the result will be 6) or "* 4 4" (the result will be 16)

    // You can use the Scanner class
    // It should work like this:

    // Start the program
    // It prints: "Please type in the expression:"
    // Waits for the user input
    // Print the result to the prompt
    // Exit

    System.out.println("Please type in the expression:");
    String userInput = scanner.nextLine();

    ArrayList<String> input = new ArrayList<>(Arrays.asList(userInput.split(" ")));

    Double operand1 = Double.valueOf(input.get(1));
    Double operand2 = Double.valueOf(input.get(2));

    if ((input.get(0)).equals("+")) {
      System.out.println(operand1 + operand2);
    } else if ((input.get(0)).equals("-")) {
      System.out.println(operand1 - operand2);
    } else if ((input.get(0)).equals("*")) {
      System.out.println(operand1 * operand2);
    } else if ((input.get(0)).equals("/")) {
      System.out.println(operand1 / operand2);
    } else if ((input.get(0)).equals("%")) {
      System.out.println(operand1 % operand2);
    } else {
      System.out.println("Operation not supported!");
    }
  }
}