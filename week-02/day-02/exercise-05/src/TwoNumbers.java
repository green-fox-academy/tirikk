public class TwoNumbers {
  public static void main(String[] args) {
    // Create a program that prints a few operations on two numbers: 22 and 13

    // Print the result of 13 added to 22

    // Print the result of 13 substracted from 22

    // Print the result of 22 mutiplied by 13

    // Print the result of 22 divided by 13 (as a decimal fraction)

    // Print the integer part of 22 divided by 13

    // Print the reminder of 22 divided by 13

    int numberOne = 13;
    int numberTwo = 22;

    System.out.println("addition: " + (numberOne+numberTwo));
    System.out.println("subtraction: " + (numberTwo-numberOne));
    System.out.println("multiplication: " + (numberOne*numberTwo));
    System.out.println("division: " + ((double)numberTwo/numberOne));
    System.out.println("int part: " + (numberTwo/numberOne));
    System.out.println("remainder: " + (numberTwo%numberOne));
  }
}