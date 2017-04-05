import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
  Animal dog;

  @BeforeEach
  public void before() {
    dog = new Animal();
  }

  @Test
  void testConstructor() {
    assertEquals(50, dog.hunger);
  }

  @Test
  void testEat() {
    dog.eat();
    assertEquals(49, dog.hunger);
  }

  @Test
  void testDrink() {
    dog.drink();
    assertEquals(49, dog.thirst);
  }

  @Test
  void testPlay() {
    dog.play();
    assertEquals(51, dog.hunger);
  }

}