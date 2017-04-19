public class Main {
  public static void main(String[] args) {

  }

  public static String[] stringSplitter(String string, int index) {
    String[] stringArray = new String[2];
    stringArray[0] = string.substring(0, index - 1);
    stringArray[1] = string.substring(index, string.length() - 1);
    return stringArray;
  }
}
