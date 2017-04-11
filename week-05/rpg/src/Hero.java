import java.awt.*;

public class Hero {
  int heroPosX = 0;
  int heroPosY = 0;
  String direction;

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
}
