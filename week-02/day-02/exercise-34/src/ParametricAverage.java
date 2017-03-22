import java.util.Scanner;

public class ParametricAverage {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Specify a number!");
    int initUserInput1 = scanner.nextInt();
    int sum = 0;

    for (int i = 1; i <= initUserInput1; i++) {
      if (i == 1) {
        System.out.println("Specify an integer:");
      } else {
        System.out.println("Specify another integer:");
      }
      int userInput1 = scanner.nextInt();
      sum = sum + userInput1;
    }
    double avg = (double)sum / (double)initUserInput1;
    System.out.println("Sum: " + sum + ", Average: " + avg);
  }
}
