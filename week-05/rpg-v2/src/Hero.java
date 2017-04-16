public class Hero extends Character {
  int moveCounter;

  Hero() {
    level = 1;
    maxHp = 20 + 3 * Dice.rollDice6();
    hp = maxHp;
    dp = 2 * Dice.rollDice6();
    sp = 5 + Dice.rollDice6();
    canMove = true;
    hasKey = false;
    moveCounter = 0;
  }
}
