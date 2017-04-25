public class Main {
  public static void main(String[] args) {
    Integer[] array = {1, 2, 3, 4, 5};
    System.out.println(sumArray(array, 3));
    System.out.println(sumArray(array, 13));
  }

  public static <T extends Number> int sumArray(T[] array, int length) {
    int sum = 0;
    try {
      for (int i = 0; i < length; i++) {
        sum += (int)((Object)(array[i]));
      }
      return sum;
    } catch (IndexOutOfBoundsException e) {
      return sum;
    }
  }
}
