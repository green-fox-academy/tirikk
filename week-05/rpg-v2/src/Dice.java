public abstract class Dice {

  static int rollDice6() {
    int rolledValue = (int) (Math.random() * 6 + 1);
    return rolledValue;
  }

  static int rollDice10() {
    int rolledValue = (int) (Math.random() * 10 + 1);
    return rolledValue;
  }
}
