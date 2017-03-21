import java.util.Scanner;
public class MileToKmConverter {
  public static void main(String[] args) {
    // Write a program that asks for an integer that is a distance in kilometers,
    // then it converts that value to miles and prints it

    Scanner scanner = new Scanner(System.in);

    System.out.println("Specify a distance in kilometers!");

    int userInput1 = scanner.nextInt();
    double converter = 0.621371192;

    System.out.println((double)userInput1 * converter);




  }
}