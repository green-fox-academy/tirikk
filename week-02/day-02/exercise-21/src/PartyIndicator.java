import java.util.Scanner;

public class PartyIndicator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Number of girls at the party:");
    int girls = scanner.nextInt();

    System.out.println("Number of boys at the party:");
    int boys = scanner.nextInt();

    int total = girls + boys;

    if (girls == 0) {
      System.out.println("Sausage party");
    } else if (total < 20) {
      System.out.println("Average party...");
    } else if (girls == boys) {
      System.out.println("The party is excellent!");
    } else {
      System.out.println("Quite cool party!");
    }
  }
}
