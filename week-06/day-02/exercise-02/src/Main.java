public class Main {
  public static void main(String[] args) {
    String string = "textToTest";
    CharOperations charOp = new CharOperations(string);

    System.out.println(string.charAt(3));
    System.out.println(charOp.charAt(3));

    System.out.println(string.subSequence(0, 4));
    System.out.println(charOp.subSequence(0, 4));

    System.out.println(string);
    System.out.println(charOp.toString());
  }
}
