
public class String3 {
  public static void main(String[] args) {
    String input = "EgyedemBegyedemTengerTanc";
    System.out.println(insertStar(input));
  }

  public static String insertStar(String input) {
    int index = 0;
    if (index == input.length() - 1) {
      return input;
    } else {
      String beginning = input.substring(0, index + 1).concat("*");;
      index++;
      return beginning.concat(insertStar(input.substring(index)));
    }
  }
}

