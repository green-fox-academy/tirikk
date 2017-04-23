import com.greenfox.bx.*;

import java.util.ArrayList;
import java.util.List;

public class CreditCardApp {

  public static void main(String[] args) {
    List<CreditCard> creditCards = new ArrayList<>();
    String[] names = {"ABC0", "ABC1", "ABC2", "ABC3", "ABC4", "ABC5", "ABC6", "ABC7", "ABC8", "ABC9"};

    for (String name : names) {
      creditCards.add(new CreditCard(name));
    }

    for (CreditCard card : creditCards) {
      System.out.println(card);
    }
  }
}