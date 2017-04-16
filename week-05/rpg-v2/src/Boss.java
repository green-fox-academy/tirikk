public class Boss extends Character {

  Boss(int level) {
    posX = 0;
    posY = 72;
    image = "assets/boss.png";
    int i = Dice.rollDice10();
    if (i < 5) {
      this.level = level;
    } else if (i < 9) {
      this.level = level + 1;
    } else {
      this.level = level + 2;
    }
    maxHp = 2 * this.level * Dice.rollDice6() + Dice.rollDice6();
    hp = maxHp;
    dp = (int)Math.ceil((double)this.level / 2) * Dice.rollDice6() + (int)Math.ceil(Dice.rollDice6() / 2);
    sp = this.level * Dice.rollDice6() + this.level;
    canMove = true;
  }
}
