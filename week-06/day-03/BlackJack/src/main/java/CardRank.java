public enum CardRank {
  TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

  static CardRank returnRank(int i) {
    return values()[values().length % i];
  }
}
