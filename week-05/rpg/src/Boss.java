import java.awt.*;
import java.util.ArrayList;

public class Boss extends Character {

  Boss(int level) {
    int i = (int) (Math.random() * 10);
    if (i < 5) {
      this.level = level;
    } else if (i < 9) {
      this.level = level + 1;
    } else {
      this.level = level + 2;
    }
    HP = 2 * this.level * (int) (Math.random() * 6 + 1) + (int) (Math.random() * 6 + 1);
    DP = (int)((double) this.level / 2 * 3 * (Math.random() * 6 + 1) / 2);
    SP = this.level * (int) (Math.random() * 6 + 1);
    canMove = true;
    posX = 144;
    posY = 144;
  }

  public int[][] genBoss(int[][] matrix) {
    int row = (int) (Math.random() * 10);
    int column = (int) (Math.random() * 10);
    if (column != 0 | row != 0) {
      if (matrix[column][row] == 0) {
        matrix[column][row] = 3;
        posX = column * 72;
        posY = row * 72;
      }
    } else {
      genBoss(matrix);
    }
    return matrix;
  }

  public void drawBoss(Graphics g, int[][] matrix) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (matrix[i][j] == 3) {
          PositionedImage image = new PositionedImage("boss.png", 72 * i, 72 * j);
          image.draw(g);
        }
      }
    }
  }

  public int[][] bossMovement(int[][] matrix) {
    ArrayList<Integer> directionsTried = new ArrayList<>();
    while (canMove && posX >= 0) {
      int direction = (int) (Math.random() * 4);
      if (direction == 0) {
        if ((posY >= 72 && matrix[posX / 72][posY / 72 - 1] == 0)) {
          matrix[posX / 72][posY / 72 - 1] = 3;
          matrix[posX / 72][posY / 72] = 0;
          posY -= 72;
          canMove = false;
        }
      } else if (direction == 1) {
        if ((posY < 648 && matrix[posX / 72][posY / 72 + 1] == 0)) {
          matrix[posX / 72][posY / 72 + 1] = 3;
          matrix[posX / 72][posY / 72] = 0;
          posY += 72;
          canMove = false;
        }
      } else if (direction == 2) {
        if ((posX >= 72 && matrix[posX / 72 - 1][posY / 72] == 0)) {
          matrix[posX / 72 - 1][posY / 72] = 3;
          matrix[posX / 72][posY / 72] = 0;
          posX -= 72;
          canMove = false;
        }
      } else {
        if ((posX < 648 && matrix[posX / 72 + 1][posY / 72] == 0)) {
          matrix[posX / 72 + 1][posY / 72] = 3;
          matrix[posX / 72][posY / 72] = 0;
          posX += 72;
          canMove = false;
        }
      }
      directionsTried.add(direction);
      if (directionsTried.contains(0) && directionsTried.contains(1) && directionsTried.contains(2) &&
              directionsTried.contains(3)) {
        canMove = false;
      }
    }
    canMove = true;
    return matrix;
  }
}
