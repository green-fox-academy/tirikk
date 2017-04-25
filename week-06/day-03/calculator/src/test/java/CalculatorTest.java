import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
  @Test
  public void testSubtract() throws Exception {
    assertEquals(-6.0, Calculator.subtract(6.0, 12), 0);
  }

  @Test
  public void testAdd() throws Exception {
    assertEquals(5.0, Calculator.add(2, 3), 0);
  }

  @Test
  public void testMultiply() throws Exception {
    assertEquals(4.444, Calculator.multiply(2.222, 2), 0);
  }

  @Test
  public void testDivision() throws Exception {
    assertEquals(2.1, Calculator.divide(6.3, 3), 0);
  }

  @Test(expected=ArithmeticException.class)
  public void testDivision_byZero() {
    Calculator.divide(5, 0);
  }
}