import java.util.Arrays;

public class Main {
  public static void main(String[] args) {

    System.out.println(Arrays.toString(stringSplitter("lovebarbara", 14)));
  }

  private static String[] stringSplitter(String string, int index) {
    String[] stringArray = new String[2];
    try {
      stringArray[0] = string.substring(0, index);
      stringArray[1] = string.substring(index, string.length());
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index is out of bounds!");
    }
    return stringArray;
  }
}
