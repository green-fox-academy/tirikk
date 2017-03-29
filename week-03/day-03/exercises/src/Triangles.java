import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {

  public static void mainDraw(Graphics graphics) {
    // reproduce this:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/triangles/r5.png]

    for (int i = 1; i < 22; i++) {
      for (int j = i; j > -i; j -= 2) {
        drawTriangle(graphics, i * 20, j * 12);
      }
    }
  }

  public static void drawTriangle(Graphics g, int offsetY, int offsetX) {
    Point[] points = {
            new Point(250 + offsetX, 50 + offsetY),
            new Point(250 + offsetX - 12, 50 + offsetY + 20),
            new Point(250 + offsetX + 12, 50 + offsetY + 20),
            new Point(250 + offsetX, 50 + offsetY)
    };
    for (int i = 0; i < 3; i++) {
      int next = i + 1;
      g.drawLine((int)points[i].getX(), (int)points[i].getY(), (int)points[next].getX(), (int)points[next].getY());
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

  static class ImagePanel extends JPanel{
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}