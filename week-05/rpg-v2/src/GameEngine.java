import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

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
      hero.moveHeroUp();
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      hero.moveHeroDown();
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      hero.moveHeroLeft();
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      hero.moveHeroRight();
    } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
      System.exit(0);
    }

    if (e.getKeyCode() != KeyEvent.VK_SPACE && e.getKeyCode() != KeyEvent.VK_ESCAPE && hero.moveCounter % 2 == 0) {
      for (Character enemy : enemyList) {
        if (enemy.canMove) {
          enemy.moveRandom();
        }
      }
    }

    repaint();
  }

  @Override
  public void paint(Graphics graphics) {
    Map.drawMap(graphics);
    for (Character character : toDraw) {
      PositionedImage image = new PositionedImage(character.image, character.posX, character.posY);
      image.draw(graphics);
    }
    hud.drawHud(graphics);
  }
}
