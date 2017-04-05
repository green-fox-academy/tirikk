import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SharpieTest {
  @Test
  void testUse() {
    Sharpie green = new Sharpie("green", 20);
    green.use();
    assertEquals(90, green.inkAmount);
  }
}