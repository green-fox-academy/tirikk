import java.util.Arrays;

public class Anagram {

  public boolean isAnagram(String input1, String input2) {
    char[] firstArray = input1.toCharArray();
    char[] secondArray = input2.toCharArray();

    Arrays.sort(firstArray);
    Arrays.sort(secondArray);

    String first = new String(firstArray);
    String second = new String(secondArray);

    return first.equals(second);
  }
}
