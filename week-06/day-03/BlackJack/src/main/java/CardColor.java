public enum CardColor {
  SPADES, DIAMONDS, CLUBS, HEARTS;

  static CardColor returnColor(int i) {
    return values()[values().length % i];
  }
}
