public class Map {
  int[][] matrix = new int[10][10];

  public int[][] mapGen() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j <10; j++) {
        matrix[i][j] = (int)(Math.random() * 2);
      }
    }
    return matrix;
  }
}
