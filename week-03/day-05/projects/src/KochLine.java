import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class KochLine {

  public static void mainDraw(Graphics graphics) {
    int lineStartX = 100;
    int lineStartY = 200;
    double lineLength = 405;
    int lineAngle = 0;
    double horDiff = lineLength * Math.cos(Math.toRadians(lineAngle));
    double verDiff = lineLength * Math.sin(Math.toRadians(lineAngle));

    ArrayList<Point> listOfPoints = new ArrayList<>();
    listOfPoints.add(new Point(lineStartX, lineStartY));
    listOfPoints.add(new Point(lineStartX + (int)horDiff, lineStartY + (int)verDiff));

    lineDrawer(graphics, generateList(3, listOfPoints, lineStartX, lineStartY, lineLength, lineAngle));
  }

  public static ArrayList<Point> generateList(int n, ArrayList<Point> list, int x, int y, double length, int angle) {

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

    Point initPoint = new Point(x, y);
    list.add(list.indexOf(initPoint) + 1, new Point((int)point3X, (int)point3Y));
    list.add(list.indexOf(initPoint) + 1, new Point((int)point2X, (int)point2Y));
    list.add(list.indexOf(initPoint) + 1, new Point((int)point1X, (int)point1Y));

    if (n > 1) {
      generateList(n - 1, list, x, y, length / 3, angle);
      generateList(n - 1, list, (int)point3X, (int)point3Y, length / 3, angle);
      generateList(n - 1, list, (int)point1X, (int)point1Y, length / 3, angle - 60);
      generateList(n - 1, list, (int)point2X, (int)point2Y, length / 3, angle + 60);
    }
    return list;
  }

  public static void lineDrawer(Graphics g, ArrayList<Point> list) {
    for (int i = 0; i < list.size() - 1; i++) {
      g.drawLine((int)list.get(i).getX(), (int)list.get(i).getY(), (int)list.get(i + 1).getX(), (int)list.get(i + 1).getY());
    }
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
      this.setBackground(Color.white);
      mainDraw(graphics);
    }
  }
}