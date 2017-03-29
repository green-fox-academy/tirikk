import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CheckerBoard {

  public static void mainDraw(Graphics graphics) {
    // fill the canvas with a checkerboard pattern.
    int inc = 300 / 8;
    for (int i = 0; i < 300 - inc; i += inc) {
      for (int j = 0; j < 300 - inc; j += inc) {
        if ((j / inc) % 2 != 0 && j != 0 && i / inc % 2 == 0) {
          drawRectangular(graphics, j, i, inc);
        } else if ((j / inc) % 2 == 0 && i / inc % 2 != 0) {
          drawRectangular(graphics, j, i, inc);
        }
      }
    }
  }


  public static void drawRectangular(Graphics g, int startX, int startY, int size) {
    g.fillRect(startX, startY, size, size);
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