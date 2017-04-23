import com.greenfox.bx.*;

import java.util.ArrayList;
import java.util.List;

public class CreditCardReservationApp {
  public static void main(String[] args) {
    List<CreditCardReservation> ccReservations = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      ccReservations.add(new CreditCardReservation(new CreditCard("DEF" + i), new Reservation()));
    }

    for (CreditCardReservation ccr : ccReservations) {
      System.out.println(ccr);
    }
  }
}
