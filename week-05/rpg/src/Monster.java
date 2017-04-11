import java.awt.*;

public class Monster {
  Map map = new Map();
  private int monsterPosX = 0;
  private int monsterPosY = 0;

  public void drawMonster(Graphics g, int x, int y) {

    PositionedImage image = new PositionedImage("hero-down.png", x, y);
    image.draw(g);
    monsterPosX = x;
    monsterPosY = y;
  }
}
