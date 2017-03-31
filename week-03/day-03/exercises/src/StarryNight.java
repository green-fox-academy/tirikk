import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight {

  public static void mainDraw(Graphics graphics) {
    // draw the night sky:
    // - The background should be black
    // - The stars can be small squares
    // - The stars should have random positions on the canvas
    // - The stars should have random color (some shade of grey)

    for (int i = 0; i < 100; i++) {
      int a = (int)(Math.random() * 255);
      graphics.setColor(new Color(a, a, a));
      int X = (int)(Math.random() * 297);
      int Y = (int)(Math.random() * 297);
      drawStars(graphics, X, Y );
    }
  }

  public static void drawStars(Graphics g, int X, int Y) {
    g.fillRect(X, Y, 3, 3);
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
      this.setBackground(Color.black);
      mainDraw(graphics);
    }
  }
}