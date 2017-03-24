import java.util.ArrayList;
import java.util.Scanner;

public class PalindromeSearch {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Type in a string please!");
    String input = scanner.nextLine();
    System.out.println("Palindromes inside the string:\n" + isPalindrome(input));
  }

  public static ArrayList isPalindrome(String input) {
    String inputSpc = input.replaceAll(" ", "");
    if (reverse(inputSpc).equals(toList(inputSpc)) && input.contains(" ")) {
      System.out.println("\nThe whole string is a palindrome. Additionally:");
    }

    ArrayList<Character> list = toList(input);
    ArrayList<String> listOut = new ArrayList<>();

    for (int i = 0; i < input.length(); i++) {
      for (int j = list.size() - 1; j > i; j--) {
        if (list.get(i) == list.get(j) && j > i + 1) {
          String temp = input.substring(i, j + 1);
          if (reverse(temp).equals(toList(temp)) && !listOut.contains("\"" + temp + "\"")) {
            listOut.add("\"" + temp + "\"");
          }
        }
      }
    }
    return listOut;
  }

  public static ArrayList toList(String input) {
    ArrayList<Character> list = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      list.add(Character.toUpperCase(input.charAt(i)));
    }
    return list;
  }

  public static ArrayList reverse(String input) {
    ArrayList<Character> revList = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      revList.add(Character.toUpperCase(input.charAt(input.length() - 1 - i)));
    }
    return revList;
  }
}
