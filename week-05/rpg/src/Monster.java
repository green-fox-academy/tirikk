import java.awt.*;

public class Monster {
  Map map = new Map();
  private int monsterPosX = 0;
  private int monsterPosY = 0;

  public void genMonster() {
    int i = 3;
    while (i > 0) {
      int row = (int) (Math.random() * 10 + 1);
      int column = (int) (Math.random() * 10 + 1);
      if (map.matrix[row][column] == 0) {
        map.matrix[row][column] = 2;
        i--;
      }
    }
  }

  public void drawMonster(Graphics g, int x, int y) {
    PositionedImage image = new PositionedImage("hero-down.png", x, y);
    image.draw(g);
    monsterPosY = y;
  }
}
