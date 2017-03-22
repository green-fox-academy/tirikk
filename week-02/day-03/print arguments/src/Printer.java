import java.util.Arrays;

public class Printer {
  public static void main(String[] args) {
    String input1 = "Monday";
    String input2 = "Tuesday";
    String input3 = "Wednesday";
    printer(input1,input2,input3);
  }

  public static void printer(String... input) {
    String output = Arrays.toString(input);
    System.out.println(output);
  }
}
