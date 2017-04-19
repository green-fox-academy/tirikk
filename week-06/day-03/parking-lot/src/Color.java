public enum Color {
  BLACK, WHITE, BLUE, GREEN, RED, YELLOW;

  static Color returnColor() {
    return values()[(int)(Math.random() * values().length)];
  }
}