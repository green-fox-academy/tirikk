import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class CAB {
  private String randomNo;
  private String state;
  private int counter;

  CAB() {
    randomGen();
    state = "playing";
    counter = 1;
  }

  public void randomGen() {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    Collections.shuffle(list);
    randomNo = "";
    if (list.get(0) != 0) {
      for (int i : list.subList(0, 4)) {
        randomNo += i;
      }
    } else {
      for (int i : list.subList(1, 5)) {
        randomNo += i;
      }
    }
  }

  public boolean checkIfValid (Integer input) {
    if (input.toString().length() != 4) {
      return false;
    }
    for (int i = 0; i < 3; i++) {
      if (StringUtils.countMatches(input.toString(), input.toString().charAt(i)) > 1) {
        return false;
      }
    }
    return true;
  }

  public void play() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Guess! (" + counter + "/8)");
    Integer userInput = scanner.nextInt();

    if (!checkIfValid(userInput)) {
      System.out.println("Your guess must contain 4 different digits, and cannot start with 0!");
      play();
    } else if (isCorrect(userInput)) {
      System.out.println("Correct!");
      state = "finished";
    } else if (counter == 8) {
      System.out.println("Game over!");
      state = "finished";
    } else {
      System.out.println(guess(userInput));
      play();
    }
  }

  public boolean isCorrect(Integer i) {
    return i.toString().equals(randomNo);
  }

  public String guess(Integer i) {
    counter++;
    int bull = 0;
    int cow = 0;
    int index = 0;
    for (Character c : i.toString().toCharArray()) {
      if (c.equals(randomNo.charAt(index))) {
        cow++;
      } else if (randomNo.indexOf(c) >= 0) {
        bull++;
      }
      index++;
    }
    return cow + " cow, " + bull + " bull";
  }

  public String getState() {
    return state;
  }

  public String getRandomNo() {
    return randomNo;
  }

  public void setRandomNo(Integer i) {
    randomNo = i.toString();
  }

  public int getCounter() {
    return counter;
  }
}
