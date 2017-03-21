import java.util.Scanner;
public class OddEven {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Specify a number please!");
    int userInput2 = scanner.nextInt();

    if (userInput2 % 2 != 0) {
      System.out.println("Odd");
    } else {
      System.out.println("Even");
    }
  }
}
