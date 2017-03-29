import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenterBoxFunction {

  public static void mainDraw(Graphics graphics){
    // create a square drawing function that takes 1 parameter:
    // the square size
    // and draws a square of that size to the center of the canvas.
    // draw 3 squares with that function.
    squareDrawer(graphics, 50);
    squareDrawer(graphics, 100);
    squareDrawer(graphics, 150);
  }

  public static void squareDrawer(Graphics g, int i) {
    g.drawRect(150 - i / 2, 150 - i / 2, i, i);
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