import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Circles {

  public static void mainDraw(Graphics graphics) {
    timesFour(graphics, 4, 50, 30, 500);
  }

  public static void timesFour(Graphics g, int n, int x, int y, int size) {
    g.drawOval(x, y, size, size);
    int horR = (int) (Math.cos(Math.toRadians(30)) * size / 4);
    int vertR = (int) (Math.sin(Math.toRadians(30)) * size / 4);
    int offsetX = size / 2 - (size / 4 + horR);
    int offsetY = size / 4 + vertR;
    if (n > 0) {
      timesFour(g, n - 1, x + size / 4, y, size / 2);
      timesFour(g, n - 1, x + offsetX, y + offsetY, size / 2);
      timesFour(g, n - 1, x + size / 2 - offsetX, y + offsetY, size / 2);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(600, 600));
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