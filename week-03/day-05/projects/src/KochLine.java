import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class KochLine {

  public static void mainDraw(Graphics graphics) {
    double lineStartX = 100;
    double lineStartY = 200;
    double lineLength = 400;
    double lineAngle = 0;

    drawInitialLine(graphics, lineStartX, lineStartY, lineLength, lineAngle);
    kochLine(graphics, 3, lineStartX, lineStartY, lineLength, lineAngle);
  }

  public static void kochLine(Graphics g, int n, double x, double y, double length, double angle) {
    double horDiff = length * Math.cos(Math.toRadians(angle));
    double verDiff = length * Math.sin(Math.toRadians(angle));
    double midHorDiff = length / 3 * Math.cos(Math.toRadians(angle - 60));
    double midVerDiff = length / 3 * Math.sin(Math.toRadians(angle - 60));
    double point1X = x + horDiff / 3;
    double point1Y = y + verDiff / 3;
    double point2X = point1X + midHorDiff;
    double point2Y = point1Y + midVerDiff;
    double point3X = x + 2 * horDiff / 3;
    double point3Y = y + 2 * verDiff / 3;

    g.drawLine((int) point1X, (int) point1Y, (int) point2X, (int) point2Y);
    g.drawLine((int) point2X, (int) point2Y, (int) point3X, (int) point3Y);

    if (n > 0) {
      kochLine(g, n - 1, x, y, length / 3, angle);
      kochLine(g, n - 1, point3X, point3Y, length / 3, angle);
      kochLine(g, n - 1, point1X, point1Y, length / 3, angle - 60);
      kochLine(g, n - 1, point2X, point2Y, length / 3, angle + 60);
    }
  }

  public static void drawInitialLine(Graphics g, double x, double y, double length, double angle) {
    double horDiff = length * Math.cos(Math.toRadians(angle));
    double verDiff = length * Math.sin(Math.toRadians(angle));
    g.drawLine((int) x, (int) y, (int) (x + horDiff), (int) (y + verDiff));
  }


  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(600, 500));
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