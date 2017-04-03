public class BattleApp {
  public static void main(String[] args) {
    Ship flyingDutchman = new Ship();
    flyingDutchman.fillShip();

    Ship blackPearl = new Ship();
    blackPearl.fillShip();

    flyingDutchman.status();
    blackPearl.status();

    blackPearl.battle(flyingDutchman);

    flyingDutchman.status();
    blackPearl.status();
  }
}
