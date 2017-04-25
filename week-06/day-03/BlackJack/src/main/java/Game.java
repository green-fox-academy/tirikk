import java.util.Arrays;
import java.util.Scanner;

class Game {
  private Deck deck;
  private Player player;
  private Player dealer;

  Game() {
    deck = new Deck();
    player = new Player();
    dealer = new Player();
    deck.shuffle();
  }

  void play() {
    dealCards();
    displayHands();
    playerTurn();
    if (player.isBust) {
      System.out.println("You went bust, game over!");
    } else {
      dealerTurn();
      if (dealer.handTotal < player.handTotal | dealer.isBust) {
        System.out.println("You Win!");
      } else if (dealer.handTotal == player.handTotal) {
        System.out.println("It's a tie!");
      } else {
        System.out.println("You Lost!");
      }
    }
  }

  private void dealCards() {
    hit(player);
    hit(dealer);
    hit(player);
  }

  private void hit(Player player) {
    player.getCard(deck.pullTop());
  }

  private void displayHands() {
    System.out.printf("Dealer's hand:\n%s (Total: %d)\nYour hand:\n%s (Total: %d)\n\n", dealer.hand, dealer.handTotal,
            player.hand, player.handTotal);
  }

  private void playerTurn() {
    while (!player.stands && !player.isBust) {
      String playerAction = promptForAction();
      if (playerAction.equals("h")) {
        hit(player);
        displayHands();
        if (player.handTotal > 21) {
          player.goBust();
        }
      } else {
        player.stand();
      }
    }
  }

  private void dealerTurn() {
    while (!dealer.isBust && !dealer.stands) {
      hit(dealer);
      displayHands();
      if (dealer.handTotal > 21) {
        dealer.goBust();
      } else if (dealer.handTotal >= 17) {
        dealer.stand();
      }
    }
  }

  private String promptForAction() {
    System.out.println("What would you like to do: (h)it, or (s)tand?");
    String[] validOptions = {"h", "s"};
    Scanner scanner = new Scanner(System.in);
    String playerInput = scanner.nextLine();
    while (!Arrays.asList(validOptions).contains(playerInput)) {
      System.out.println("That's not a valid option.");
      playerInput = promptForAction();
    }
    return playerInput;
  }
}
