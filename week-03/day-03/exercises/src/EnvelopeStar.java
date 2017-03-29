import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {

  public static void mainDraw(Graphics graphics) {
    // reproduce this:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/envelope-star/r2.png]
    graphics.setColor(Color.green);
    for (int i = 0; i <= 150; i += 10) {
      lineDrawer(graphics, i, 150, 150, 150 - i);
      lineDrawer(graphics, 150, i, 150 + i, 150);
      lineDrawer(graphics, i, 150, 150, 150 + i);
      lineDrawer(graphics, 150 + i, 150, 150, 300 - i);
    }
  }

  public static void lineDrawer(Graphics graphics, int startX, int startY, int x, int y) {
    graphics.drawLine(startX, startY, x, y);
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