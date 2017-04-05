import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {
  Sum sumInstance;

  @BeforeEach
  public void before() {
    sumInstance = new Sum();
  }


  @Test
  void testSumWithList() {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 1; i < 6; i++) {
      list.add(i);
    }
    assertEquals(15, sumInstance.sum(list));
  }

  @Test
  void testSumWithEmptyList() {
    ArrayList<Integer> list = new ArrayList<>();
    assertEquals(0, sumInstance.sum(list));
  }

  @Test
  void testSumWithOneElement() {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(5);
    assertEquals(5, sumInstance.sum(list));
  }

  @Test
  void testSumWithNull() {
    ArrayList<Integer> list = null;
    assertEquals(0, sumInstance.sum(list));
  }
}