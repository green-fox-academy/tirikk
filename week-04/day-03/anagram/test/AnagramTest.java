import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {
  @Test
  void isAnagram() {
    Anagram anagram = new Anagram();
    assertTrue(anagram.isAnagram("abcd", "bcad"));
  }
}