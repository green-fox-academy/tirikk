import javax.swing.*;

public class Main {
  public static void main(String[] args) {

    JFrame frame = new JFrame("RPG Game");
    Board board = new Board();
    Hero hero = new Hero();
    frame.add(board);
//    frame.add(hero);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();

    frame.addKeyListener(hero);
  }
}
