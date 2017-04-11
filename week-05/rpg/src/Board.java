import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {
  Map map = new Map();
  Hero hero = new Hero();
  Monster monsters = new Monster();


  public Board() {
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);
    map.mapGetFromFile();
    monsters.genMonster();
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
      if (hero.heroPosY >= 72 && map.matrix[hero.heroPosX / 72][hero.heroPosY / 72 - 1] != 1) {
        hero.heroPosY -= 72;
      }
      hero.direction = "up";
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      if (hero.heroPosY < 648 && map.matrix[hero.heroPosX / 72][hero.heroPosY / 72 + 1] != 1) {
        hero.heroPosY += 72;
      }
      hero.direction = "down";
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      if (hero.heroPosX >= 72 && map.matrix[hero.heroPosX / 72 - 1][hero.heroPosY / 72] != 1) {
        hero.heroPosX -= 72;
      }
      hero.direction = "left";
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      if (hero.heroPosX < 648 && map.matrix[hero.heroPosX / 72 + 1][hero.heroPosY / 72] != 1) {
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
    monsters.drawMonster(graphics);
  }
}
