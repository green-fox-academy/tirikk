public class Pirates {
  int intoxication = 0;
  boolean alive = true;
  boolean awake = true;
  boolean parrot = true;

  public void drinkSomeRum() {
    if (alive) {
      intoxication++;
    } else {
      System.out.println("he's dead");
    }
  }

  public void howsItGoingMate() {
    if (intoxication < 5 && alive) {
      System.out.println("Pour me anudder");
    } else if (alive) {
      System.out.println("Arghh, I'ma Pirate, How d'ya d'ink its goin?");
      awake = false;
      intoxication = 0;
    } else {
      System.out.println("he's dead");
    }
  }

  public void die() {
    alive = false;
  }

  public void brawl(Pirates pirate) {
    if (pirate.alive) {
      int i = (int)(Math.random() * 3 + 1);
      if (i == 1) {
        this.die();
      } else if (i == 2) {
        pirate.die();
      } else {
        this.awake = false;
        pirate.awake = false;
      }
    }
  }
}
