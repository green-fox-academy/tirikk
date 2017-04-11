import java.awt.*;

public class Hero {
  Map map = new Map();
  private int heroPosX = 0;
  private int heroPosY = 0;
  private String direction;

  public void drawHero(Graphics g) {
    if (direction == "right") {
      PositionedImage image = new PositionedImage("hero-right.png", heroPosX, heroPosY);
      image.draw(g);
    } else if (direction == "left") {
      PositionedImage image = new PositionedImage("hero-left.png", heroPosX, heroPosY);
      image.draw(g);
    } else if (direction == "up") {
      PositionedImage image = new PositionedImage("hero-up.png", heroPosX, heroPosY);
      image.draw(g);
    } else {
      PositionedImage image = new PositionedImage("hero-down.png", heroPosX, heroPosY);
      image.draw(g);
    }
  }

  public void heroMovementY(int i) {
    map.getMapFromFile();
    if (i < 0) {
      if (heroPosY >= 72 && map.matrix[heroPosX / 72][heroPosY / 72 - 1] != 1) {
        heroPosY += i;
      }
      direction = "up";
    } else {
      if (heroPosY < 648 && map.matrix[heroPosX / 72][heroPosY / 72 + 1] != 1) {
        heroPosY += i;
      }
      direction = "down";
    }
  }

  public void heroMovementX(int i) {
    map.getMapFromFile();
    if (i < 0) {
      if (heroPosX >= 72 && map.matrix[heroPosX / 72 - 1][heroPosY / 72] != 1) {
        heroPosX += i;
      }
      direction = "left";
    } else {
      if (heroPosX < 648 && map.matrix[heroPosX / 72 + 1][heroPosY / 72] != 1) {
        heroPosX += i;
      }
      direction = "right";
    }
  }
}
