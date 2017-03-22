public class Colors {
  public static void main(String[] args) {

    String[][] colors = new String[3][];
    String[] green = {"lime,", "forest green,", "olive,", "pale green,", "spring green,"};
    String[] red = {"orange red,", "red,", "tomato,"};
    String[] pink = {"orchid,", "violet,", "pink,", "hot pink,"};

    colors[0] = green;
    colors[1] = red;
    colors[2] = pink;

    for (int i = 0; i < colors.length; i++) {
      for (int j = 0; j < colors[i].length; j++) {
        System.out.print(" " + colors[i][j]);
      }
      System.out.println();
    }
  }
}
