import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FunctionToCenter {

  public static void mainDraw(Graphics graphics) {
    // create a line drawing function that takes 2 parameters:
    // the x and y coordinates of the line's starting point
    // and draws a line from that point to the center of the canvas.
    // fill the canvas with lines from the edges, every 20 px, to the center.
    graphics.drawRect(0, 0, 300, 300);
    for (int i = 0; i <= 300; i += 20) {
      for (int j = 0; j <= 300; j += 20) {
        if (j == 0 || j == 300) {
          lineDrawer(graphics, i, j);
        }
        if (i == 0 || i == 300) {
          lineDrawer(graphics, i, j);
        }
      }
    }

  }

  public static void lineDrawer(Graphics graphics, int x, int y) {
    graphics.drawLine(x, y, 150, 150);
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