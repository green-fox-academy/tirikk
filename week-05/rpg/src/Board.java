import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener{
  Map map = new Map();
  Hero hero = new Hero();
  Monster monsters = new Monster();
  Boss boss = new Boss();

  public Board() {
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);
    map.getMapFromFile();
    monsters.genMonster();
    boss.genBoss();
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
      hero.heroMovementY(-72);
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      hero.heroMovementY(72);
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      hero.heroMovementX(-72);
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      hero.heroMovementX(72);
    }
    repaint();
  }

  @Override
  public void paint(Graphics graphics) {
    map.drawMap(graphics);
    monsters.drawMonster(graphics);
    boss.drawBoss(graphics);
    hero.drawHero(graphics);
  }
}
