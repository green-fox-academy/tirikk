import java.awt.*;

public class Map {
  static int[][] mapMatrix = {
          {0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
          {0, 0, 1, 0, 1, 1, 1, 0, 0, 0},
          {0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
          {0, 0, 1, 0, 1, 0, 1, 0, 1, 0},
          {1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
          {0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
          {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
          {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
          {0, 0, 1, 1, 1, 0, 0, 0, 0, 0}
  };

  static void drawMap(Graphics g) {
    for (int column = 0; column < 10; column++) {
      for (int row = 0; row < 10; row++) {
        if (mapMatrix[row][column] == 1) {
          PositionedImage image = new PositionedImage("assets/wall.png", 72 * column, 72 * row);
          image.draw(g);
        } else {
          PositionedImage image = new PositionedImage("assets/floor.png", 72 * column, 72 * row);
          image.draw(g);
        }
      }
    }
  }
}
