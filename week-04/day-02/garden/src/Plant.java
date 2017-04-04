public class Plant {
  private String color;
  private double waterAmount;

  public double getWater() {
    return waterAmount;
  }

  public String getColor() {
    return color;
  }

  public void setWater (double i) {
    waterAmount += i;
  }

  Plant(String color) {
    this.color = color;
    waterAmount = 0;
  }
}
