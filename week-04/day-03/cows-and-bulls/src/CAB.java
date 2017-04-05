import java.util.Random;

public class CAB {
  private Integer randomNo;
  private String state;
  private int counter;

  CAB() {
    Random random = new Random();
    randomNo = random.nextInt(9000) + 1000;
    state = "playing";
    counter = 0;
  }

  public Integer getRandom() {
    return randomNo;
  }

  public void guess(Integer i) {
    int bull = 0;
    int cow = 0;
    if (i.equals(randomNo)) {
      System.out.println("Correct!");
    } else {
      for (Character c : i.toString().toCharArray()) {
        if (c.equals(randomNo.toString().charAt(i.toString().indexOf(c)))) {
          cow++;
        } else if (randomNo.toString().indexOf(c) >= 0) {
          bull++;
        }
      }
      System.out.println(cow + " cow," + bull + " bull");
    }
  }
}
