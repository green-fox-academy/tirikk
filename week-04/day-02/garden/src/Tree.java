public class Tree extends Plant {

  public boolean needsWater() {
    if (this.getWater() < 10) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void addWater (double i) {
    this.setWater(i * 0.4);
  }


  Tree(String color) {
    super(color);
  }
}
