public class Card {
  CardColor color;
  CardRank rank;

  Card() {
    color = CardColor.returnColor((int) (Math.random() * 4));
    rank = CardRank.returnRank((int) (Math.random() * 13));
  }

  Card(CardColor color, CardRank rank) {
    this.color = color;
    this.rank = rank;
  }

  @Override
  public String toString() {
    return String.format("%s of %s", rank, color);
  }
}
