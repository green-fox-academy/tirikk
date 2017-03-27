import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EncodedLines {
  public static void main(String[] args) {
    try {
      Path filePath = Paths.get("assets/encoded-lines.txt");
      List<String> lines = Files.readAllLines(filePath);

      Path decodedPath = Paths.get("assets/decoded.txt");
      Files.write(decodedPath, decode(lines));
      List<String> decodedLines = Files.readAllLines(decodedPath);
      display(decodedLines);

    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }
  }

  public static List<String> decode(List<String> listToDecode) {
    ArrayList<String> reversed = new ArrayList<>();
    for (String row : listToDecode) {
      String temp = "";
      for (int i = 0; i < row.length(); i++) {
        if (row.charAt(i) != (char)32) {
          temp += (char)((int)row.charAt(i) - 1);
        } else {
          temp += row.charAt(i);
        }
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
