import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SquareGrid {

  public static void mainDraw(Graphics graphics) {
    timesFour(graphics, 3, 150, 150, 200);
  }

  public static void timesFour(Graphics g, int n, int x, int y, int size) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(4 * n));
    g2d.setColor(Color.black);
    g2d.drawRect(x, y, size, size);
    if (n > 0) {
      timesFour(g, n - 1, x - size / 4, y - size / 4, size / 2);
      timesFour(g, n - 1, x - size / 4, y + 3 * size / 4, size / 2);
      timesFour(g, n - 1, x +  3 * size / 4, y - size / 4, size / 2);
      timesFour(g, n - 1, x + 3 * size / 4, y + 3 * size / 4, size / 2);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(550, 550));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}