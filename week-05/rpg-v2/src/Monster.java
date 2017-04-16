import java.util.ArrayList;

public class Monster extends Character {
  static ArrayList<Monster> monsterList = new ArrayList<>();

  Monster(int level) {
    posX = 0;
    posY = 0;
    image = "assets/skeleton.png";
    int i = Dice.rollDice10();
    if (i < 5) {
      this.level = level;
    } else if (i < 9) {
      this.level = level + 1;
    } else {
      this.level = level + 2;
    }
    maxHp = 2 * this.level * Dice.rollDice6();
    hp = maxHp;
    dp = (int) Math.ceil((double)this.level / 2) * Dice.rollDice6();
    sp = this.level * Dice.rollDice6();
    canMove = true;
    hasKey = false;
  }

  static void generateMonsters(int n, int level) {
    monsterList.clear();
    int i = 0;
    while (i < n) {
      int column = (int) (Math.random() * 10);
      int row = (int) (Math.random() * 10);
      if (column != 0 | row != 0) {
        if (Map.isFloor(column, row) && !Map.isOccupied(column, row)) {
          monsterList.add(new Monster(level));
          monsterList.get(i).posX = column * 72;
          monsterList.get(i).posY = row * 72;
          Map.setOccupied(column, row);
          i++;
        }
      }
    }
    monsterList.get(1).hasKey = true;
  }
}
