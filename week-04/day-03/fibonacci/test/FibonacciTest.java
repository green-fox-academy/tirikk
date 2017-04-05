import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

  @Test
  void testFibonacci() {
    Fibonacci fibToTest = new Fibonacci();
    assertEquals(34, fibToTest.fibonacci(9));
  }

}