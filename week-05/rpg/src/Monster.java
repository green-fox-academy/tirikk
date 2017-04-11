import java.awt.*;

public class Monster {
  Map map = new Map();
  private int monsterPosX = 0;
  private int monsterPosY = 0;

  public void genMonster() {
    map.mapGetFromFile();
    int i = 3;
    while (i > 0) {
      int row = (int) (Math.random() * 10);
      int column = (int) (Math.random() * 10);
      if (!(column == 0 && row == 0))
      if (map.matrix[column][row] == 0) {
        map.matrix[column][row] = 2;
        i--;
      }
    }
  }

  public void drawMonster(Graphics g) {
    int k = 0;
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (map.matrix[i][j] == 2) {
          PositionedImage image = new PositionedImage("skeleton.png", 72 * i, 72 * j);
          image.draw(g);
          k++;
        }
      }
    }
  }
}