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

  int heroPosX;
  int heroPosY;
  String direction;

  public Board() {
    heroPosX = 0;
    heroPosY = 0;

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
      if (heroPosY >= 72 && map.mapGet()[heroPosX / 72][heroPosY / 72 - 1] != 1) {
        heroPosY -= 72;
      }
      direction = "up";
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      if (heroPosY < 648 && map.mapGet()[heroPosX / 72][heroPosY / 72 + 1] != 1) {
        heroPosY += 72;
      }
      direction = "down";
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      if (heroPosX >= 72 && map.mapGet()[heroPosX / 72 - 1][heroPosY / 72] != 1) {
        heroPosX -= 72;
      }
      direction = "left";
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      if (heroPosX < 648 && map.mapGet()[heroPosX / 72 + 1][heroPosY / 72] != 1) {
        heroPosX += 72;
      }
      direction = "right";
    }
    repaint();
  }

  @Override
  public void paint(Graphics graphics) {
    drawMap(graphics);
    Hero hero = new Hero();
    hero.drawHero(graphics, heroPosX, heroPosY, direction);
  }

  public void drawMap(Graphics g) {
    int[][] walls = map.mapGet();

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (walls[i][j] == 1) {
          PositionedImage image = new PositionedImage("wall.png", 72 * i, 72 * j);
          image.draw(g);
        } else {
          PositionedImage image = new PositionedImage("floor.png", 72 * i, 72 * j);
          image.draw(g);
        }
      }
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
