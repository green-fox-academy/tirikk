import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Hexagon {

  public static void mainDraw(Graphics graphics) {
    fractalHexagon(graphics, 5, 150, 50, 200);

  }

  public static void fractalHexagon(Graphics graphics, int n, int x, int y, int size) {
    int diagonal = (int) (Math.sqrt(3) * size);
    drawHexagon(graphics, x, y, size);
    if (n > 0) {
      fractalHexagon(graphics, n - 1, x, y, size / 3);
      fractalHexagon(graphics, n - 1, x + 2 * size / 3, y, size / 3);
      fractalHexagon(graphics, n - 1, x - size / 3, y + diagonal / 3, size / 3);
      fractalHexagon(graphics, n - 1, x + size, y + diagonal / 3, size / 3);
      fractalHexagon(graphics, n - 1, x, y + 2 * diagonal / 3, size / 3);
      fractalHexagon(graphics, n - 1, x + 2 * size / 3, y + 2 * diagonal / 3, size / 3);
    }
  }

  public static void drawHexagon(Graphics g, int x, int y, int size) {
    int diagonal = (int) (Math.sqrt(3) * size);
    int npoints = 6;
    int xpoints[] = {x, x + size, (int) (x + 1.5 * size), x + size, x, x - size / 2};
    int ypoints[] = {y, y, y + diagonal / 2, y + diagonal, y + diagonal, y + diagonal / 2};
    g.setColor(Color.white);
    g.fillPolygon(xpoints, ypoints, npoints);
    g.setColor(Color.black);
    g.drawPolygon(xpoints, ypoints, npoints);
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
      mainDraw(graphics);
    }
  }
}