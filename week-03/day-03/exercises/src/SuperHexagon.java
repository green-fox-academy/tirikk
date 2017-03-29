import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SuperHexagon {

  public static void mainDraw(Graphics graphics) {
    // reproduce this:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/super-hexagon/r6.gif]

    int diagonal = (int) (Math.sqrt(3) * 20);
    for (int i = 1; i < 14; i++) {
      if (i < 4) {
        for (int j = -i; j < i; j += 2) {
          drawHexagon(graphics, j * 30, i * (diagonal / 2));
        }
      } else if (i < 11 && i % 2 == 0) {
        for (int j = -4; j < 4; j += 2) {
          drawHexagon(graphics, j * 30, i * (diagonal / 2));
        }
      } else if (i < 11 && i % 2 != 0) {
        for (int j = -3; j < 3; j += 2) {
          drawHexagon(graphics, j * 30, i * (diagonal / 2));
        }
      } else {
        for (int j = -(14 - i); j < 14 - i; j += 2) {
          drawHexagon(graphics, j * 30, i * (diagonal / 2));
        }
      }
    }
  }

  public static void drawHexagon(Graphics g, int offsetX, int offsetY) {
    int diagonal = (int) (Math.sqrt(3) * 20);
    int startX = 150 + offsetX;
    int startY = 20 + offsetY;
    int npoints = 6;
    int xpoints[] = {startX, startX + 20, startX + 30, startX + 20, startX, startX - 10};
    int ypoints[] = {startY, startY, startY + diagonal / 2, startY + diagonal, startY + diagonal, startY + diagonal /
            2};
    g.drawPolygon(xpoints, ypoints, npoints);
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