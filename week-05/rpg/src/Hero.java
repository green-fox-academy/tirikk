import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

  public class PositionedImage {

    BufferedImage image;
    int posX, posY;

    public PositionedImage(String filename, int posX, int posY) {
      this.posX = posX;
      this.posY = posY;
      try {
        image = ImageIO.read(new File(filename));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public void draw(Graphics graphics) {
      if (image != null) {
        graphics.drawImage(image, posX, posY, null);
      }
    }
  }
}
