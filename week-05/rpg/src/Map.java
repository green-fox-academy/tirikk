import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Map {
  int[][] matrix = new int[10][10];

  public void mapGen() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j <10; j++) {
        matrix[i][j] = (int)(Math.random() * 2);
      }
    }
  }

  public void mapGetFromFile() {
    Path filePath = Paths.get("matrix.txt");
    List<String> initList;
    try {
      initList = Files.readAllLines(filePath);
      for (String line : initList) {
        for (int i = 0; i < line.length(); i++) {
          if (line.charAt(i) == '1') {
            matrix[i][initList.indexOf(line)] = 1;
          } else {
            matrix[i][initList.indexOf(line)] = 0;
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void drawMap(Graphics g) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (matrix[i][j] == 1) {
          PositionedImage image = new PositionedImage("wall.png", 72 * i, 72 * j);
          image.draw(g);
        } else {
          PositionedImage image = new PositionedImage("floor.png", 72 * i, 72 * j);
          image.draw(g);
        }
      }
    }
  }
}
