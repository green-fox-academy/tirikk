import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CountLettersTest {
  @Test
  void countLetters() {
    CountLetters cLetter = new CountLetters();
    HashMap<Character, Integer> expected = new HashMap<>();
    expected.put('a', 2);
    expected.put('b', 2);
    expected.put('c', 2);
    expected.put('d', 2);
    assertEquals(expected, cLetter.countLetters("abcdabcd"));
  }

}