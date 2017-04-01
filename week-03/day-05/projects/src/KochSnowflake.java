import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class KochSnowflake {

  public static void mainDraw(Graphics graphics) {
    int startX = 100;
    int startY = 400;
    double size = 400;
    int angle = 0;
    int iterationNo = 4;

    polygonDrawer(graphics, generateList(iterationNo, startX, startY, size, angle));
  }

  public static ArrayList<Point> generateList(int n, int x, int y, double size, int angle) {
    double horDiff = size * Math.cos(Math.toRadians(angle));
    double verDiff = size * Math.sin(Math.toRadians(angle));
    double midHorDiff = size * Math.cos(Math.toRadians(angle - 60));
    double midVerDiff = size * Math.sin(Math.toRadians(angle - 60));
    double midPointX = x + midHorDiff;
    double midPointY = y + midVerDiff;
    double endPointX = x + horDiff;
    double endPointY = y + verDiff;

    ArrayList<Point> listOfPoints = new ArrayList<>();
    listOfPoints.add(new Point(x, y));
    listOfPoints.add(new Point((int)midPointX, (int)midPointY));
    listOfPoints.add(new Point((int)endPointX, (int)endPointY));

    listOfPoints = populateList(n, listOfPoints, x, y, size, angle - 60);
    listOfPoints = populateList(n, listOfPoints, (int)midPointX, (int)midPointY, size, angle + 60);
    listOfPoints = populateList(n, listOfPoints, (int)endPointX, (int)endPointY, size, angle + 180);

    return listOfPoints;
  }

  public static ArrayList<Point> populateList(int n, ArrayList<Point> list, int x, int y, double length, int angle) {
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
      populateList(n - 1, list, x, y, length / 3, angle);
      populateList(n - 1, list, (int)point3X, (int)point3Y, length / 3, angle);
      populateList(n - 1, list, (int)point1X, (int)point1Y, length / 3, angle - 60);
      populateList(n - 1, list, (int)point2X, (int)point2Y, length / 3, angle + 60);
    }
    return list;
  }

  public static void polygonDrawer(Graphics g, ArrayList<Point> list) {
    int[] xCoor = new int[list.size()];
    int[] yCoor = new int[list.size()];
    int nPoints = list.size();
    for (int i = 0; i < list.size(); i++) {
      xCoor[i] = (int)list.get(i).getX();
      yCoor[i] = (int)list.get(i).getY();
    }
    g.drawPolygon(xCoor, yCoor, nPoints);
  }

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