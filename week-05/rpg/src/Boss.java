import java.awt.*;

public class Boss {
  Map map = new Map();
  private int monsterPosX = 0;
  private int monsterPosY = 0;

  public void genBoss() {
    map.getMapFromFile();
    int row = (int) (Math.random() * 10);
    int column = (int) (Math.random() * 10);
    if (!(column == 0 && row == 0)) {
      if (map.matrix[column][row] == 0) {
        map.matrix[column][row] = 3;
      }
    }
  }

  public void drawBoss(Graphics g) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (map.matrix[i][j] == 3) {
          PositionedImage image = new PositionedImage("boss.png", 72 * i, 72 * j);
          image.draw(g);
        }
      }
    }
  }
}