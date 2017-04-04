public class Flower extends Plant{

  public boolean needsWater() {
    if (this.getWater() < 5) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void addWater (double i) {
    this.setWater(i * 0.75);
  }

  Flower(String color) {
    super(color);
  }
}
