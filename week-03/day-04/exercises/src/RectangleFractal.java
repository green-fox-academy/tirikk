import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RectangleFractal {

  public static void mainDraw(Graphics graphics) {
    perThree(graphics, 5, 0, 0, 486);
  }

  public static void perThree(Graphics g, int n, int x, int y, int size) {
    g.drawRect(x, y, size, size);
    if (n > 0) {
      perThree(g, n - 1, x + size / 3, y, size / 3);
      perThree(g, n - 1, x, y + size / 3, size / 3);
      perThree(g, n - 1, x + size /  3, y + 2 * size / 3, size / 3);
      perThree(g, n - 1, x + 2 * size /  3, y + size / 3, size / 3);
    }
  }

  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(486, 486));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      this.setBackground(Color.yellow);
      mainDraw(graphics);
    }
  }
}