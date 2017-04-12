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

  public void Strike() {
    int SV = hero.SP * (2 * (int)(Math.random() * 6 + 1));
    if (SV > boss.DP) {
      boss.HP -= 
    }
  }

}
