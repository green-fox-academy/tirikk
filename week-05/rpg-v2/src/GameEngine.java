import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEngine extends JComponent implements KeyListener {

  public GameEngine() {
    setPreferredSize(new Dimension(1200, 720));
    setVisible(true);
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {

    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

    } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
      System.exit(0);
    }

    repaint();
  }

  @Override
  public void paint(Graphics graphics) {

  }
}
