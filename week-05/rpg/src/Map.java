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

  public int[][] mapGet() {
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
    return matrix;
  }
}
