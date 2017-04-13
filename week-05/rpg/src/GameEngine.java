import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEngine extends JComponent implements KeyListener {
  int level = 1;
  Map map = new Map();
  Hero hero = new Hero();
  int[][] matrix = map.getMapFromFile();
  Monster monsters = new Monster(level);
  Boss boss = new Boss(level);
  HUD hud;

  public GameEngine() {
    setPreferredSize(new Dimension(1100, 720));
    setVisible(true);
    matrix = monsters.genMonster(matrix, level);
    matrix = boss.genBoss(matrix);
    hud = new HUD(hero, monsters, boss);
  }

  public GameEngine(Hero hero, int level) {
    this.level = level;
    setPreferredSize(new Dimension(1100, 720));
    setVisible(true);
    this.hero = hero;
    monsters = new Monster(level);
    boss = new Boss(level);
    matrix = monsters.genMonster(matrix, level);
    matrix = boss.genBoss(matrix);
    hud = new HUD(hero, monsters, boss);
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
    } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
      System.exit(0);
    }
    if (hero.moveCounter % 2 == 0) {
      matrix = boss.bossMovement(matrix);
      matrix = monsters.monsterMovement(matrix);
    }
    repaint();
    if (hero.posX == boss.posX && hero.posY == boss.posY && boss.HP > 0) {
      Battlefield battlefield = new Battlefield(hero, boss);
      if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        if (battlefield.fight()) {
          if (hero.hasKey) {
            hero.hasKey = false;
            hero.levelUp();
            hero.posY = 0;
            hero.posX = 0;
            Main.main(hero, level + 1);
          }
          matrix[boss.posX / 72][boss.posY / 72] = 0;
        } else {
          hero.canMove = false;
        }
      }
    }
    for (Monster monster : monsters.monsters) {
      if (hero.posX == monster.posX && hero.posY == monster.posY && monster.HP > 0) {
        Battlefield battlefield = new Battlefield(hero, monster);
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
          if (battlefield.fight()) {
            matrix[monster.posX / 72][monster.posY / 72] = 0;
            if (monster.hasKey) {
              if (boss.HP <= 0) {
                hero.levelUp();
                hero.posY = 0;
                hero.posX = 0;
                Main.main(hero, level + 1);
              } else {
                hero.hasKey = true;
                monster.hasKey = false;
              }
            }
          } else {
            hero.canMove = false;
          }
        }
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
