import java.util.ArrayList;
import java.util.List;

class Player {
  boolean isBust = false;
  boolean stands = false;
  List<Card> hand = new ArrayList<>();
  int handTotal = 0;

  void getCard(Card card) {
    hand.add(card);
    handTotal += card.value;
  }

  void goBust() {
    isBust = true;
  }

  void stand() {
    stands = true;
  }
}
