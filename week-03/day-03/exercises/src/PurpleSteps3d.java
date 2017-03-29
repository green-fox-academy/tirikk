import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PurpleSteps3d {

  public static void mainDraw(Graphics graphics){
    // reproduce this:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/purple-steps-3d/r4.png]
    int startLine = 10;
    for (int i = 0; i < 6; i++) {
      startLine += (i * 10) + 1;
      int size = (i + 1) * 10;
      drawRectangular(graphics, startLine, size);
    }
  }

  public static void drawRectangular(Graphics g, int startLine, int size) {
    g.setColor(Color.black);
    g.drawRect(startLine, startLine, size + 1, size + 1);
    g.setColor(new Color(169, 67, 232));
    g.fillRect(startLine + 1, startLine + 1, size, size);
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