import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
  private List<Card> cards = new ArrayList<>();

  Deck() {
    for (CardColor color : CardColor.values()) {
      for (CardRank rank : CardRank.values()) {
        cards.add(new Card(color, rank));
      }
    }
  }

  void shuffle() {
    Collections.shuffle(cards);
  }

  Card pullBottom() {
    Card card = cards.get(0);
    cards.remove(0);
    return card;
  }

  Card pullTop() {
    Card card = cards.get(cards.size() - 1);
    cards.remove(cards.size() - 1);
    return card;
  }

  Card pullRandom() {
    Card card = cards.get((int) (Math.random() * cards.size()));
    cards.remove((int) (Math.random() * cards.size()));
    return card;
  }
}
