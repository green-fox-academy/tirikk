public class Boss extends Character {

  Boss(int level) {
    posX = 0;
    posY = 0;
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
    direction = generateDirection();
  }

  void generatePosition() {
    int column = (int) (Math.random() * 10);
    int row = (int) (Math.random() * 10);
    if (column != 0 | row != 0) {
      if (Map.isFloor(column, row) && !Map.isOccupied(column, row)) {
        posX = column * 72;
        posY = row * 72;
        Map.setOccupied(column, row);
      } else {
        generatePosition();
      }
    } else {
      generatePosition();
    }
  }
}
