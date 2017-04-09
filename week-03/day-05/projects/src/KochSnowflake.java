import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class KochSnowflake {

  static void mainDraw(Graphics graphics) {
    int startX = 100;
    int startY = 400;
    double size = 400;
    int angle = 0;
    int iterationNo = 4;

    polygonDrawer(graphics, generateList(iterationNo, startX, startY, size, angle));
  }

  private static ArrayList<Point> generateList(int n, int x, int y, double size, int angle) {

    HashMap<String, Point> mapOfPoints = doTheMath(x, y, size, angle);

    ArrayList<Point> listOfPoints = new ArrayList<>();
    listOfPoints.add(mapOfPoints.get("startPoint"));
    listOfPoints.add(mapOfPoints.get("midPoint"));
    listOfPoints.add(mapOfPoints.get("endPoint"));

    listOfPoints = populateList(n, listOfPoints, x, y, size, angle - 60);
    listOfPoints = populateList(n, listOfPoints, mapOfPoints.get("midPoint").x, mapOfPoints.get("midPoint").y, size,
            angle + 60);
    listOfPoints = populateList(n, listOfPoints, mapOfPoints.get("endPoint").x, mapOfPoints.get("endPoint").y, size,
            angle + 180);

    return listOfPoints;
  }

  private static ArrayList<Point> populateList(int n, ArrayList<Point> list, int x, int y, double length, int angle) {

    HashMap<String, Point> mapOfPoints = doTheMath(x, y, length, angle);

    list.add(list.indexOf(mapOfPoints.get("startPoint")) + 1, mapOfPoints.get("point3"));
    list.add(list.indexOf(mapOfPoints.get("startPoint")) + 1, mapOfPoints.get("point2"));
    list.add(list.indexOf(mapOfPoints.get("startPoint")) + 1, mapOfPoints.get("point1"));

    if (n > 1) {
      populateList(n - 1, list, x, y, length / 3, angle);
      populateList(n - 1, list, mapOfPoints.get("point3").x,  mapOfPoints.get("point3").y, length / 3, angle);
      populateList(n - 1, list, mapOfPoints.get("point1").x, mapOfPoints.get("point1").y, length / 3, angle - 60);
      populateList(n - 1, list, mapOfPoints.get("point2").x, mapOfPoints.get("point2").y, length / 3, angle + 60);
    }
    return list;
  }

  private static HashMap<String, Point> doTheMath(int x, int y, double length, int angle) {
    double horDiff = length * Math.cos(Math.toRadians(angle));
    double verDiff = length * Math.sin(Math.toRadians(angle));
    double midHorDiffTriangle = length * Math.cos(Math.toRadians(angle - 60));
    double midVerDiffTriangle = length * Math.sin(Math.toRadians(angle - 60));
    double midHorDiffLine = length / 3 * Math.cos(Math.toRadians(angle - 60));
    double midVerDiffLine = length / 3 * Math.sin(Math.toRadians(angle - 60));
    double midPointX = x + midHorDiffTriangle;
    double midPointY = y + midVerDiffTriangle;
    double endPointX = x + horDiff;
    double endPointY = y + verDiff;
    double point1X = x + horDiff / 3;
    double point1Y = y + verDiff / 3;
    double point2X = point1X + midHorDiffLine;
    double point2Y = point1Y + midVerDiffLine;
    double point3X = x + 2 * horDiff / 3;
    double point3Y = y + 2 * verDiff / 3;

    HashMap<String, Point> mapOfPoints = new HashMap<>();
    mapOfPoints.put("startPoint", new Point(x,y));
    mapOfPoints.put("midPoint", new Point((int)midPointX,(int)midPointY));
    mapOfPoints.put("endPoint", new Point((int)endPointX,(int)endPointY));
    mapOfPoints.put("point1", new Point((int)point1X,(int)point1Y));
    mapOfPoints.put("point2", new Point((int)point2X,(int)point2Y));
    mapOfPoints.put("point3", new Point((int)point3X,(int)point3Y));

    return mapOfPoints;
  }

  private static void polygonDrawer(Graphics g, ArrayList<Point> list) {
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