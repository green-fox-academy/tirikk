import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {
  Map map = new Map();
  Hero hero = new Hero();
  int[][] matrix = map.getMapFromFile();
  Monster monsters = new Monster(map.levelNo);
  Boss boss = new Boss(map.levelNo);
  HUD hud = new HUD(hero, monsters, boss);

  public Board() {
    setPreferredSize(new Dimension(1100, 720));
    setVisible(true);
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
    if (e.getKeyCode() == KeyEvent.VK_UP) {
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
    if (hero.posX == boss.posX && hero.posY == boss.posY) {
      Battlefield battlefield = new Battlefield(hero, boss);
      if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        battlefield.fight();
        matrix[boss.posX / 72][boss.posY / 72] = 0;
        boss.posX = -72;
        boss.posY = -72;
      }
    }
    repaint();
  }

  @Override
  public void paint(Graphics graphics) {
    map.drawMap(graphics);
    monsters.drawMonster(graphics, matrix);
    boss.drawBoss(graphics, matrix);
    hero.drawHero(graphics);
    hud.drawHUD(graphics, matrix);
  }
}
