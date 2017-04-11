import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
