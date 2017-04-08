import java.util.ArrayList;

public class Ship {
  ArrayList<Pirates> crew;
  Pirates captain;
  int aliveNo = 0;

  public void fillShip() {
    captain = new Pirates();
    crew = new ArrayList<>();
    int i = (int) (Math.random() * 10);
    for (int j = 0; j < i; j++) {
      crew.add(new Pirates());
    }
  }

  public void status() {
    System.out.println("Rum consumed by captain: " + captain.intoxication);
    if (!captain.alive) {
      System.out.println("The captain is dead");
    }
    if (!captain.awake) {
      System.out.println("The captain passed out");
    }
    aliveNo = 0;
    for (Pirates crewMember : crew) {
      if (crewMember.alive) {
        this.aliveNo++;
      }
    }
    System.out.println("Pirates in crew still alive: " + aliveNo);
    System.out.println();
  }

  public boolean battle(Ship othership) {
    int actualScore = aliveNo - captain.intoxication;
    int otherScore = othership.aliveNo - othership.captain.intoxication;
    if (actualScore > otherScore) {
      int deaths = (int) (Math.random() * othership.crew.size());
      for (int j = 0; j < deaths; j++) {
        othership.crew.get(j).alive = false;
      }
      int rum = (int) (Math.random() * 5);
      for (int k = 0; k < rum; k++) {
        this.captain.drinkSomeRum();
        for (Pirates crewMember : this.crew) {
          crewMember.drinkSomeRum();
        }
      }
      return true;
    } else {
      int deaths = (int) (Math.random() * this.crew.size());
      for (int j = 0; j < deaths; j++) {
        this.crew.get(j).alive = false;
      }
      int rum = (int) (Math.random() * 10);
      for (int k = 0; k < rum; k++) {
        othership.captain.drinkSomeRum();
        for (Pirates crewMember : othership.crew) {
          crewMember.drinkSomeRum();
        }
      }
      return false;
    }
  }
}
