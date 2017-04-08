import java.util.ArrayList;
import java.util.List;

public class Armada {
  List<Ship> shipList = new ArrayList<>();

  public void addShip(Ship ship) {
    shipList.add(ship);
  }

  public void fillArmada() {
    for (int i = 0; i < 5; i++) {
      Ship temp = new Ship();
      temp.fillShip();
      shipList.add(temp);
    }
  }

  public boolean war(Armada armada) {
    int i = 0;
    int j = 0;

    while (i < shipList.size() && j < armada.shipList.size()) {
      if (shipList.get(i).battle(armada.shipList.get(j))) {
        j++;
      } else {
        i++;
      }
    }
    return i < shipList.size() && j == armada.shipList.size();
  }
}
