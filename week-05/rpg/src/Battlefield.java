public class Battlefield {
  Hero hero;
  Monster monster;
  Boss boss;

  Battlefield(Hero hero, Boss boss) {
    this.hero = hero;
    this.boss = boss;
    hero.canMove = false;
    boss.canMove = false;
  }

  public void fight() {
    while (boss.HP > 0) {
      strike();
    }
    hero.canMove = true;
  }

  public void strike() {
    int SV = hero.SP * (2 * (int)(Math.random() * 6 + 1));
    if (SV > boss.DP) {
      boss.HP -= (SV - boss.DP);
    }
  }
}
