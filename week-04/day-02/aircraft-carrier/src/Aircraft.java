public class Aircraft {
  String type;
  int ammo;
  int maxAmmo;
  int baseDamage;

  public int fight() {
    int damage = ammo * baseDamage;
    ammo = 0;
    return damage;
  }

  public int refill(int i) {
    if (ammo + i > maxAmmo) {
      int remainder = i - (maxAmmo - ammo);
      ammo = maxAmmo;
      return remainder;
    } else {
      ammo += i;
      return 0;
    }
  }

  public String getType() {
    return type;
  }

  public String getStatus() {
    return "Type " + type + ", Ammo: " + ammo + ", Base Damage: " + baseDamage + ", All Damage: " + baseDamage * ammo;
  }

  Aircraft() {
    ammo = 0;
  }
}
