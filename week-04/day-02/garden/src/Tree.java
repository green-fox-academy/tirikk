public class Tree extends Plant {

  public boolean needsWater() {
    if (this.getWater() < 10) {
      return true;
    } else {
      return false;
    }
  }

  public void water(double i) {
    this.setWater(i);
  }

  Tree(String color) {
    super(color);
  }
}
