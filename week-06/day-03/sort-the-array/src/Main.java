import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Integer[] array = {5, 105, 11, 175};
    System.out.println(Arrays.toString(sortArray(array)));

  }

  public static <T extends Number> T[] sortArray(T[] array) {
    Arrays.sort(array);
    for (int i = 0; i < array.length / 2; i++) {
      T temp = array[i];
      array[i] = array[array.length - 1 - i];
      array[array.length - 1 - i] = temp;
    }
    return array;
  }
}
