import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Extension {
  int add(int a, int b) {
    return a + b;
  }

  int maxOfThree(int a, int b, int c) {
    return Math.max(Math.max(a, b), c);
  }

  int median(List<Integer> pool) {
    Collections.sort(pool);
    if (pool.size() % 2 != 0) {
      return pool.get((pool.size() - 1) / 2);
    } else {
      return (pool.get((pool.size() - 1) / 2) + (pool.get(pool.size() / 2))) / 2;
    }
  }

  boolean isVowel(char c) {
    return Arrays.asList('a', 'á', 'u', 'ú', 'ü', 'ű', 'o', 'ó', 'ö', 'ő', 'e', 'é', 'i', 'í').contains(c);
  }

  String translate(String hungarian) {
    String teve = hungarian;
    int length = teve.length();
    for (int i = 0; i < length; i++) {
      char c = teve.charAt(i);
      if (isVowel(c)) {
        teve = String.join(c + "v" + c, teve.split(""+c));
        i+=2;
        length+=2;
      }
    }
    return teve;
  }
}