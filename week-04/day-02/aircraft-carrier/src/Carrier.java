import java.util.ArrayList;

public class Carrier {
  ArrayList<Aircraft> aircrafts;
  int ammoStorage;
  int health;

  public void addAircraft(String type) {
    if (type == "F16") {
      aircrafts.add(new F16());
    } else if (type == "F35") {
      aircrafts.add(new F35());
    }
  }

  public void fill() {
    if (ammoStorage > 0) {
      for (Aircraft aircraft : aircrafts) {
        if (aircraft.type == "F35") {
          ammoStorage = aircraft.refill(ammoStorage);
        }
      }
      for (Aircraft aircraft : aircrafts) {
        ammoStorage = aircraft.refill(ammoStorage);
      }
    } else {
      System.out.println("There's no ammo left");
    }
  }

  public void fight(Carrier other) {
    int damage = 0;
    for (Aircraft aircraft : aircrafts) {
      damage += aircraft.fight();
    }
    other.health -= damage;
  }

  public void getStatus () {
    int totalDamage = 0;
    for (Aircraft aircraft : aircrafts) {
      totalDamage += (aircraft.ammo * aircraft.baseDamage);
    }
    if (health > 0) {
      System.out.println("Aircraft count: " + aircrafts.size() + ", Ammo Storage: " + ammoStorage + ", Total damage: " +
              "" + totalDamage);
      System.out.println("Aircrafts:");
      for (Aircraft aircraft : aircrafts) {
        System.out.println("Type " + aircraft.type + ", Ammo: " + aircraft.ammo + ", Base Damage: " + aircraft
                .baseDamage + ", All Damage: " + aircraft.ammo * aircraft.baseDamage);
      }
    } else {
      System.out.println("It's dead Jim :(");
    }
  }

  Carrier(int ammo) {
    aircrafts = new ArrayList<>();
    ammoStorage = ammo;
    health = 100;
  }
}
