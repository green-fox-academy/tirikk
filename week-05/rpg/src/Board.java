import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Board extends JComponent implements KeyListener {
  Map map = new Map();
  Hero hero = new Hero();

//  int heroPosX;
//  int heroPosY;
//  String direction;

  public Board() {
//    heroPosX = 0;
//    heroPosY = 0;

    setPreferredSize(new Dimension(720, 720));
    setVisible(true);
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP ) {
      if (hero.heroPosY >= 72 && map.mapGet()[hero.heroPosX / 72][hero.heroPosY / 72 - 1] != 1) {
        hero.heroPosY -= 72;
      }
      hero.direction = "up";
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      if (hero.heroPosY < 648 && map.mapGet()[hero.heroPosX / 72][hero.heroPosY / 72 + 1] != 1) {
        hero.heroPosY += 72;
      }
      hero.direction = "down";
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      if (hero.heroPosX >= 72 && map.mapGet()[hero.heroPosX / 72 - 1][hero.heroPosY / 72] != 1) {
        hero.heroPosX -= 72;
      }
      hero.direction = "left";
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      if (hero.heroPosX < 648 && map.mapGet()[hero.heroPosX / 72 + 1][hero.heroPosY / 72] != 1) {
        hero.heroPosX += 72;
      }
      hero.direction = "right";
    }
    repaint();
  }

  @Override
  public void paint(Graphics graphics) {
    map.drawMap(graphics);
    hero.drawHero(graphics);
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
