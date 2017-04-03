public class Main {
  public static void main(String[] args) {
    Pirates jackSparrow = new Pirates();
    Pirates norrington = new Pirates();
    Pirates bootstrapBill = new Pirates();

    while (jackSparrow.intoxication < 4) {
      jackSparrow.drinkSomeRum();
    }

    jackSparrow.howsItGoingMate();
    jackSparrow.drinkSomeRum();

    jackSparrow.howsItGoingMate();

    norrington.brawl(bootstrapBill);
    bootstrapBill.howsItGoingMate();
    norrington.howsItGoingMate();
    
  }
}
