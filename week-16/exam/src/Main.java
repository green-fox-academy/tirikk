import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    System.out.println(transformList(Arrays.asList("abc", "ijk", "xyz")));
  }

  static List<String> transformList(List<String> inputList) {
    List<String> outputList = new ArrayList<>();
    for (int i = 0; i < inputList.size(); i++) {
      StringBuilder builder = new StringBuilder("");
      for (String string : inputList) {
        builder.append(string.charAt(i));
      }
      outputList.add(builder.toString());
    }
    return outputList;
  }
}
