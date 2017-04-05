import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SharpieTest {
  @Test
  void testUse() {
    Sharpie green = new Sharpie("green", 20);
    green.use();
    assertEquals(90, green.inkAmount);
  }

  @Test
  void testColor() {
    Sharpie green = new Sharpie("green", 20);
    assertEquals("green", green.color);
  }

  @Test
  void testWidth() {
    Sharpie green = new Sharpie("green", 20);
    assertEquals(20, green.width);
  }

  @Test
  void testInkAmount() {
    Sharpie green = new Sharpie("green", 20);
    assertEquals(100, green.inkAmount);
  }
}