public class CharOperations implements CharSequence {
  String string;

  CharOperations(String string) {
    this.string = string;
  }

  public char charAt(int index) {
    return string.charAt(string.length() - 1 - index);
  }

  public int length() {
    return string.length();
  }

  public CharSequence subSequence(int start, int end) {
    String reversedSubString = "";
    for (int i = end - 1; i >= start; i--) {
      reversedSubString += string.charAt(i);
    }
    return reversedSubString;
  }

  public String toString() {
    String reversedString = "";
    for (int i = string.length() - 1; i >= 0; i--) {
      reversedString += string.charAt(i);
    }
    return reversedString;
  }
}
