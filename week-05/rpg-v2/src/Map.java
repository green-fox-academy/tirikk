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

  static boolean isFloor(int column, int row) {
    return mapMatrix[row][column] != 1;
  }

  static boolean isOccupied(int column, int row) {
    return mapMatrix[row][column] == 2;
  }

  static void setOccupied(int column, int row) {
    mapMatrix[row][column] = 2;
  }

  static void setUnoccupied(int column, int row) {
    mapMatrix[row][column] = 0;
  }
}
