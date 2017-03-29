import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {

  public static void mainDraw(Graphics graphics){
    // divide the canvas into 4 parts
    // and repeat this pattern in each quarter:
    // [https://github.com/greenfox-academy/teaching-materials/blob/master/exercises/drawing/line-play/r1.png]
    graphics.drawRect(0, 0, 300, 300);
    graphics.drawLine(0, 150, 300, 150);
    graphics.drawLine(150, 0, 150, 300);
    for (int i = 10; i < 150; i += 10) {
      graphics.setColor(new Color(169, 67, 232));
      lineDrawer(graphics, i, 0, 150, i);
      lineDrawer(graphics, 150 + i, 0, 300, i);
      lineDrawer(graphics, i, 150, 150, 150 + i);
      lineDrawer(graphics, 150 + i, 150, 300, 150 + i);
      graphics.setColor(Color.green);
      lineDrawer(graphics, 0, i, i, 150);
      lineDrawer(graphics, 150, i, 150 + i, 150);
      lineDrawer(graphics, 0, 150 + i, i, 300);
      lineDrawer(graphics, 150, 150 + i, 150 + i, 300);
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