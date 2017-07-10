import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {
  @Test
  public void transformList() throws Exception {
    List<String> inputList = Arrays.asList("abcd", "efgh", "ijkl", "mnop");
    List<String> expectedList = Arrays.asList("aeim", "bfjn", "cgko", "dhlp");
    assertEquals(expectedList, Main.transformList(inputList));
  }

}