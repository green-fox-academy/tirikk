import java.awt.*;

public class Monster {
  private int monsterPosX = 0;
  private int monsterPosY = 0;

  public int[][] genMonster(int[][] matrix) {
    int i = 0;
    while (i < 3) {
      int row = (int) (Math.random() * 10);
      int column = (int) (Math.random() * 10);
      if (!(column == 0 && row == 0)) {
        if (matrix[column][row] == 0) {
          matrix[column][row] = 2;
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
}