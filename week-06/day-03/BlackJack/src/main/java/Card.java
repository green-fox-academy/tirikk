public class Card {
  private CardColor color;
  private CardRank rank;
  int value;

  Card() {
    color = CardColor.returnColor((int) (Math.random() * 4));
    rank = CardRank.getRank((int) (Math.random() * 13));
    value = rank.getRankValue();
  }

  Card(CardColor color, CardRank rank) {
    this.color = color;
    this.rank = rank;
    value = rank.getRankValue();
  }

  @Override
  public String toString() {
    return String.format("%s of %s", rank, color);
  }
}
