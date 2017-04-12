import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener{
  Map map = new Map();
  Hero hero = new Hero();
  Monster monsters = new Monster(map.levelNo);
  Boss boss = new Boss(map.levelNo);
  int[][] matrix = new int[10][10];

  public Board() {
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);
    matrix = map.getMapFromFile();
    matrix = monsters.genMonster(matrix, map.levelNo);
    matrix = boss.genBoss(matrix);
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
      hero.heroMovementY(-72, matrix);
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      hero.heroMovementY(72, matrix);
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      hero.heroMovementX(-72, matrix);
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      hero.heroMovementX(72, matrix);
    }
    if (hero.moveCounter % 2 == 0) {
      matrix = boss.bossMovement(matrix);
      matrix = monsters.monsterMovement(matrix);
    }
    repaint();
  }

  @Override
  public void paint(Graphics graphics) {
    map.drawMap(graphics);
    monsters.drawMonster(graphics, matrix);
    boss.drawBoss(graphics, matrix);
    hero.drawHero(graphics);
  }
}
