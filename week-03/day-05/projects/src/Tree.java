import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Tree {

  public static void mainDraw(Graphics graphics) {
    tree(graphics, 8,250, 400, 40, -90);
  }

  public static void tree(Graphics g, int n, int x, int y, int length, int angle) {
    int horDiff = (int) (Math.cos(Math.toRadians(angle)) * length);
    int verDiff = (int) (Math.sin(Math.toRadians(angle)) * length);
    int endX = x + horDiff;
    int endY = y + verDiff;
    g.setColor(new Color(254, 214, 47));
    g.drawLine(x, y, endX, endY);

    if (n > 0) {
      tree(g, n - 1, endX, endY, length, angle);
      tree(g, n - 1, endX, endY, 9 * length / 10, angle + 25);
      tree(g, n - 1, endX, endY, 9 * length / 10, angle - 25);
    }
  }



  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(500, 500));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      this.setBackground(new Color(0, 49, 62));
      mainDraw(graphics);
    }
  }
}