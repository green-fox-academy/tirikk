import java.util.HashMap;

public class CountLetters {

  public HashMap<Character, Integer> countLetters(String input) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < input.length(); i++) {
      if (!map.containsKey(input.charAt(i))) {
        map.put(input.charAt(i), 1);
      } else {
        map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
      }
    }
    return map;
  }
}
