public class String2 {
  public static void main(String [] args) {
    String input = "XxXxXxXxX";
    System.out.println(xToY(input));
  }
  public static String xToY(String input) {
    if (!input.contains("x")) {
      return input;
    } else {
      input = input.replaceFirst("x", "");
      return xToY(input);
    }
  }
}