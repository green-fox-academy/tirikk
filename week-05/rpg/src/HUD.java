import java.awt.*;

public class HUD {
  Hero hero;
  Monster monster;
  Boss boss;

  HUD(Hero hero, Monster monster, Boss boss) {
    this.hero = hero;
    this.monster = monster;
    this.boss = boss;
  }

  public void drawHUD(Graphics g, int[][] matrix) {
    g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
    if (hero.HP > 0) {
      g.drawString("Hero (Level " + hero.level + ") HP: " + hero.HP + " | DP: " + hero.DP + " | SP: " + hero.SP, 750,
              40);
      if (hero.hasKey) {
        g.drawString("You've got the key!", 750, 60);
      }
      for (Monster monster : monster.monsters) {
        if (hero.posX == monster.posX && hero.posY == monster.posY && monster.HP > 0) {
          g.drawString("Monster (Level " + monster.level + ") HP: " + monster.HP + " | DP: " + monster.DP + " | SP: "
                  + monster.SP, 750, 80);
          if (monster.hasKey) {
            g.drawString("It has the key!", 750, 100);
          }
        }
      }
      if (hero.posX == boss.posX && hero.posY == boss.posY && boss.HP > 0) {
        g.drawString("Boss (Level " + boss.level + ") HP: " + boss.HP + " | DP: " + boss.DP + " | SP: "
                + boss.SP, 750, 80);
      }
    } else {
      g.drawString("Game Over! Press 'Esc' to quit!", 750, 40);
    }
  }
}
