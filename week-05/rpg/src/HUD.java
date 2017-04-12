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
    g.drawString("Hero (Level " + hero.level + ") HP: " + hero.HP + " | DP: " + hero.DP + " | SP: " + hero.SP, 750,
            40);
    for (Monster monster : monster.monsters) {
      if (hero.heroPosX == monster.monsterPosX && hero.heroPosY == monster.monsterPosY) {
        g.drawString("Monster (Level " + monster.level + ") HP: " + monster.HP + " | DP: " + monster.DP + " | SP: "
                + monster.SP, 750, 60);
      }
    }
  }
}
