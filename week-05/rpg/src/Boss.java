import java.awt.*;

public class Boss {
  private int monsterPosX = 0;
  private int monsterPosY = 0;

  public int[][] genBoss(int[][] matrix) {
    int row = (int) (Math.random() * 10);
    int column = (int) (Math.random() * 10);
    if (!(column == 0 && row == 0)) {
      if (matrix[column][row] == 0) {
        matrix[column][row] = 3;
        monsterPosX = column * 72;
        monsterPosY = row * 72;
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
    int canMove = 1;
    while (canMove > 0) {
      int direction = (int) (Math.random() * 4);
      if (direction == 0) {
        if ((monsterPosY >= 72 && matrix[monsterPosX / 72][monsterPosY / 72 - 1] != 1)) {
          matrix[monsterPosX / 72][monsterPosY / 72 - 1] = 3;
          matrix[monsterPosX / 72][monsterPosY / 72] = 0;
          monsterPosY -= 72;
          canMove--;
        }
      } else if (direction == 1) {
        if ((monsterPosY < 648 && matrix[monsterPosX / 72][monsterPosY / 72 + 1] != 1)) {
          matrix[monsterPosX / 72][monsterPosY / 72 + 1] = 3;
          matrix[monsterPosX / 72][monsterPosY / 72] = 0;
          monsterPosY += 72;
          canMove--;
        }
      } else if (direction == 2) {
        if ((monsterPosX >= 72 && matrix[monsterPosX / 72 - 1][monsterPosY / 72] != 1)) {
          matrix[monsterPosX / 72 - 1][monsterPosY / 72] = 3;
          matrix[monsterPosX / 72][monsterPosY / 72] = 0;
          monsterPosX -= 72;
          canMove--;
        }
      } else {
        if ((monsterPosX < 648 && matrix[monsterPosX / 72 + 1][monsterPosY / 72] != 1)) {
          matrix[monsterPosX / 72 + 1][monsterPosY / 72] = 3;
          matrix[monsterPosX / 72][monsterPosY / 72] = 0;
          monsterPosX += 72;
          canMove--;
        }
      }
    }
    return matrix;
  }
}