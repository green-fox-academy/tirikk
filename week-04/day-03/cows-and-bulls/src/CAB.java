import com.sun.xml.internal.fastinfoset.util.CharArray;

public class CAB {
  private Integer random;
  private String state;
  private int counter;

  CAB() {
    random = 5698;
//    random = (int) (Math.random() * 9999);
    state = "playing";
    counter = 0;
  }

  public Integer getRandom() {
    return random;
  }

  public void guess(Integer i) {
    int bull = 0;
    int cow = 0;
    if (i.equals(random)) {
      System.out.println("Correct!");
    } else {
      for (Character c : i.toString().toCharArray()) {
        if (c.equals(random.toString().charAt(i.toString().indexOf(c)))) {
          cow++;
        } else if (random.toString().indexOf(c) >= 0) {
          bull++;
        }
      }
      System.out.println(cow + " cow," + bull + " bull");
    }
  }
}
