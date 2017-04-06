import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CABTest {
  @Test
  void testRandomGen() {
    CAB cab = new CAB();
    assertEquals(4, cab.getRandomNo().length());
    assertFalse(cab.getRandomNo().charAt(0) == 0);
  }

  @Test
  void testCheckIfValid_1111() {
    CAB cab = new CAB();
    assertFalse(cab.checkIfValid(1111));
  }

  @Test
  void testCheckIfValid_1234() {
    CAB cab = new CAB();
    assertTrue(cab.checkIfValid(1234));
  }

  @Test
  void testIsCorrect() {
    CAB cab = new CAB();
    assertTrue(cab.isCorrect(Integer.valueOf(cab.getRandomNo())));
  }

  @Test
  void testGuess() {
    CAB cab = new CAB();
    cab.setRandomNo(1234);
    assertEquals("0 cow, 4 bull", cab.guess(4321));
  }

  @Test
  void testGetState_atStart() {
    CAB cab = new CAB();
    assertEquals("playing", cab.getState());
  }

  @Test
  void testGetCounter() {
    CAB cab = new CAB();
    cab.setRandomNo(1234);
    cab.guess(4321);
    assertEquals(2, cab.getCounter());
  }
}