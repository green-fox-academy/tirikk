public class Battlefield {
  Character attacker;
  Character defender;

  Battlefield(Character attacker, Character defender) {
    this.attacker = attacker;
    this.defender = defender;
    attacker.canMove = false;
    defender.canMove = false;
  }

  public boolean fight() {
    while (attacker.HP > 0 && defender.HP > 0) {
      strike(attacker, defender);
      if (defender.HP > 0) {
        strike(defender, attacker);
      }
    }
    if (attacker.HP > 0) {
      attacker.canMove = true;
      return true;
    } else {
      return false;
    }
  }

  public void strike(Character attacker, Character defender) {
    int SV = attacker.SP + (2 * (int) (Math.random() * 6 + 1));
    if (SV > defender.DP) {
      defender.HP -= (SV - defender.DP);
    }
  }
}
