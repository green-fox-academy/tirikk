import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {

  public static void mainDraw(Graphics graphics) {
    // reproduce this:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/line-play/r1.png]
    graphics.drawRect(0, 0, 300, 300);
    for (int i = 10; i < 300; i += 20) {
      graphics.setColor(new Color(169, 67, 232));
      lineDrawer(graphics, i, 0, 300, i);
      graphics.setColor(Color.green);
      lineDrawer(graphics, 0, i, i, 300);
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
  static class ImagePanel extends JPanel{
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}