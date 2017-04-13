import javax.swing.*;
import java.util.ArrayList;

public class Main {
  static ArrayList<JFrame> frameList = new ArrayList<>();
  public static void main(String[] args) {

    JFrame frame = new JFrame("RPG Game");
    frameList.add(frame);
    GameEngine gameEngine = new GameEngine();
    frame.add(gameEngine);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();

    frame.addKeyListener(gameEngine);
  }

  public static void main(Hero hero, int level) {
    JFrame frame = new JFrame("RPG Game");
    frameList.add(frame);
    frameList.get(0).dispose();
    frameList.remove(0);
    GameEngine gameEngine = new GameEngine(hero, level);
    frame.add(gameEngine);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();

    frame.addKeyListener(gameEngine);
  }
}
