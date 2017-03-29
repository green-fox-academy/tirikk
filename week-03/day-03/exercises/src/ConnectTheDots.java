import javax.swing.*;

import java.awt.*;
import java.util.Arrays;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectTheDots {

  public static void mainDraw(Graphics graphics) {
    // create a function that takes 1 parameter:
    // an array of {x, y} points
    // and connects them with green lines.
    // connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
    // connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
    // {120, 100}, {85, 130}, {50, 100}}

    Point[] points = {
            new Point(10, 10),
            new Point(290, 10),
            new Point(290, 290),
            new Point(10, 290),
            new Point(10, 10)
    };

    Point[] points2 = {
            new Point(50, 100),
            new Point(70, 70),
            new Point(80, 90),
            new Point(90, 90),
            new Point(100, 70),
            new Point(120, 100),
            new Point(85, 130),
            new Point(50, 100)
    };
    lineDrawer(graphics, points2);
  }

  public static void lineDrawer(Graphics graphics, Point[] coor) {
    for (int i = 0; i < coor.length - 1; i++) {
      int next = i + 1;
      graphics.drawLine((int)coor[i].getX(), (int)coor[i].getY(), (int)coor[next].getX(), (int)coor[next].getY());
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(300, 300));
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