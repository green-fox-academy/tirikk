public class Flower extends Plant{

  public boolean needsWater() {
    if (this.getWater() < 5) {
      return true;
    } else {
      return false;
    }
  }

  public void water(double i) {
    this.setWater(i);
  }

  Flower(String color) {
    super(color);
  }
}
