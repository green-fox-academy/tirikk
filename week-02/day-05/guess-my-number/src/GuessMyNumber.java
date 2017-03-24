import java.util.Random;

public class GuessMyNumber {
  public static void main(String[] args) {

    System.out.println(randomGen(2, 10));
  }

  public static int randomGen(int min, int max) {
    Random rand = new Random();
    int number = rand.nextInt((max - min) + 1) + min;
    return number;
  }
}
