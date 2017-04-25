public enum Size {
  INCH15, INCH17, INCH19, INCH21, INCH23, INCH25, INCH29, INCH34;

  static Size returnSize() {
    return values()[(int) (Math.random() * values().length)];
  }
}
