import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

public class GameEngine extends JComponent implements KeyListener {
  Hero hero = new Hero();
  Boss boss;
  HUD hud;
  ArrayList<Character> toDraw = new ArrayList<>();
  ArrayList<Character> enemyList = new ArrayList<>();
  int level = 0;

  public GameEngine() {
    setPreferredSize(new Dimension(1200, 720));
    setVisible(true);
    generateElements();
  }

  void generateElements() {
    level++;
    hero.posX = 0;
    hero.posY = 0;
    hero.image = "assets/hero-down.png";
    toDraw.clear();
    enemyList.clear();
    boss = new Boss(level);
    Monster.generateMonsters(3, level);
    for (Monster skeleton : Monster.monsterList) {
      toDraw.add(skeleton);
      enemyList.add(skeleton);
    }
    boss.generatePosition();
    toDraw.add(boss);
    enemyList.add(boss);
    toDraw.add(hero);
    hud = new HUD(hero, enemyList);
    Map.initMap();
    Map.genPath(0, 0);
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP && hero.canMove) {
      hero.moveHeroUp();
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN && hero.canMove) {
      hero.moveHeroDown();
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT && hero.canMove) {
      hero.moveHeroLeft();
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && hero.canMove) {
      hero.moveHeroRight();
    } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
      System.exit(0);
    }

    if (e.getKeyCode() != KeyEvent.VK_SPACE && e.getKeyCode() != KeyEvent.VK_ESCAPE && hero.moveCounter % 2 == 0 &&
            hero.canMove) {
      for (Character enemy : enemyList) {
        if (enemy.canMove) {
          enemy.moveRandom();
        }
      }
    }

    for (Character enemy : enemyList) {
      if (hero.posX == enemy.posX && hero.posY == enemy.posY && enemy.hp > 0) {
        hero.canMove = false;
        enemy.canMove = false;
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
          if (hero.moveCounter % 2 == 0) {
            enemy.fight(hero);
          } else {
            hero.fight(enemy);
          }
        }
      }
    }

    if (hero.hp <= 0) {
      hero.die();
    }

    for (Iterator<Character> it = enemyList.iterator(); it.hasNext(); ) {
      Character enemy = it.next();
      if (enemy.hp <= 0) {
        if (enemy.hasKey) {
          hero.hasKey = true;
        }
        enemy.die();
        hero.levelUp();
        it.remove();
        Map.setUnoccupied(enemy.posX / 72, enemy.posY / 72);
        hero.canMove = true;
      }
    }

    if (boss.hp == 0 && hero.hasKey) {
      hero.hasKey = false;
      hero.enterNextLevel();
      generateElements();
    }
    repaint();
  }

  @Override
  public void paint(Graphics graphics) {
    Map.drawMap(graphics);
//    for (Character character : toDraw) {
//      PositionedImage image = new PositionedImage(character.image, character.posX, character.posY);
//      image.draw(graphics);
//    }
//    hud.drawHud(graphics);
  }
}
