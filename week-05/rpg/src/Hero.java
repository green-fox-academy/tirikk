import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Hero {
  private int heroPosX = 0;
  private int heroPosY = 0;

  public void drawHero(Graphics g, int x, int y, String direction) {
    if (direction == "right") {
      PositionedImage image = new PositionedImage("hero-right.png", x, y);
      image.draw(g);
    } else if (direction == "left") {
      PositionedImage image = new PositionedImage("hero-left.png", x, y);
      image.draw(g);
    } else if (direction == "up") {
      PositionedImage image = new PositionedImage("hero-up.png", x, y);
      image.draw(g);
    } else {
      PositionedImage image = new PositionedImage("hero-down.png", x, y);
      image.draw(g);
    }
    heroPosX = x;
    heroPosY = y;
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
