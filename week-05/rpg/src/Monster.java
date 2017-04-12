import java.awt.*;
import java.util.ArrayList;

public class Monster {
  private int monsterPosX = 0;
  private int monsterPosY = 0;
  ArrayList<Monster> monsters = new ArrayList<>();

  public int[][] genMonster(int[][] matrix) {
    int i = 0;
    while (i < 3) {
      int row = (int) (Math.random() * 10);
      int column = (int) (Math.random() * 10);
      if (!(column == 0 && row == 0)) {
        if (matrix[column][row] == 0) {
          matrix[column][row] = 2;
          monsters.add(new Monster());
          monsters.get(i).monsterPosY = row * 72;
          monsters.get(i).monsterPosX = column * 72;
          i++;
        }
      }
    }
    return matrix;
  }

  public void drawMonster(Graphics g, int[][] matrix) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (matrix[i][j] == 2) {
          PositionedImage image = new PositionedImage("skeleton.png", 72 * i, 72 * j);
          image.draw(g);
        }
      }
    }
  }

  public int[][] monsterMovement(int[][] matrix) {
    for (Monster monster : monsters) {
      int canMove = 1;
      while (canMove > 0) {
        int direction = (int) (Math.random() * 4);
        if (direction == 0) {
          if ((monster.monsterPosY >= 72 && matrix[monster.monsterPosX / 72][monster.monsterPosY / 72 - 1] == 0)) {
            matrix[monster.monsterPosX / 72][monster.monsterPosY / 72 - 1] = 2;
            matrix[monster.monsterPosX / 72][monster.monsterPosY / 72] = 0;
            monster.monsterPosY -= 72;
            canMove--;
          }
        } else if (direction == 1) {
          if ((monster.monsterPosY < 648 && matrix[monster.monsterPosX / 72][monster.monsterPosY / 72 + 1] == 0)) {
            matrix[monster.monsterPosX / 72][monster.monsterPosY / 72 + 1] = 2;
            matrix[monster.monsterPosX / 72][monster.monsterPosY / 72] = 0;
            monster.monsterPosY += 72;
            canMove--;
          }
        } else if (direction == 2) {
          if ((monster.monsterPosX >= 72 && matrix[monster.monsterPosX / 72 - 1][monster.monsterPosY / 72] == 0)) {
            matrix[monster.monsterPosX / 72 - 1][monster.monsterPosY / 72] = 2;
            matrix[monster.monsterPosX / 72][monster.monsterPosY / 72] = 0;
            monster.monsterPosX -= 72;
            canMove--;
          }
        } else {
          if ((monster.monsterPosX < 648 && matrix[monster.monsterPosX / 72 + 1][monster.monsterPosY / 72] == 0)) {
            matrix[monster.monsterPosX / 72 + 1][monster.monsterPosY / 72] = 2;
            matrix[monster.monsterPosX / 72][monster.monsterPosY / 72] = 0;
            monster.monsterPosX += 72;
            canMove--;
          }
        }
      }
    }
    return matrix;
  }
}