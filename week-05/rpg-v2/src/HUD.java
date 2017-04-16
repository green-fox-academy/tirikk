import java.awt.*;
import java.util.ArrayList;

public class HUD {
  Character hero;
  ArrayList<Character> enemyList = new ArrayList<>();

  HUD(Character hero, ArrayList enemyList) {
    this.hero = hero;
    this.enemyList = enemyList;
  }

  void drawHud(Graphics g) {
    g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
    if (hero.hp > 0) {
      g.drawString("Hero (Level " + hero.level + ") HP: " + hero.hp + "/" + hero.maxHp + " | DP: " + hero.dp + " | SP:" +
              " " + hero.sp, 750, 40);
      if (hero.hasKey) {
        g.drawString("You've got the key!", 750, 60);
      }
      for (Character enemy : enemyList) {
        if (hero.posX == enemy.posX && hero.posY == enemy.posY && enemy.hp > 0) {
          g.drawString("Enemy (Level " + enemy.level + ") HP: " + enemy.hp + "/" + enemy.maxHp + " | DP: " + enemy
                  .dp + " | SP: " + enemy.sp, 750, 80);
          if (enemy.hasKey) {
            g.drawString("It has the key!", 750, 100);
          }
        }
      }
    } else {
      g.drawString("Game Over! Press 'Esc' to quit!", 750, 40);
    }
  }
}
