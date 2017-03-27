import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class reversedLines {
  public static void main(String[] args) {
    try {
      Path filePath = Paths.get("assets/reversed-lines.txt");
      List<String> lines = Files.readAllLines(filePath);

      Path reversedPath = Paths.get("assets/reversed.txt");
      Files.write(reversedPath, reverse(lines));
      List<String> reversedLines = Files.readAllLines(reversedPath);
      display(reversedLines);

    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }
  }

  public static List<String> reverse(List<String> input) {
    ArrayList<String> reversed = new ArrayList<>();
    for (String row : input) {
      String temp = "";
      for (int i = 0; i < row.length(); i++) {
        temp = temp + row.charAt(row.length() - i - 1);
      }
      reversed.add(temp);
    }
    return reversed;
  }

  public static void display(List<String> input) {
    for (String row : input) {
      System.out.println(row);
    }
  }
}
