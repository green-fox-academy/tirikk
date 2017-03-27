import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class doubled {
  public static void main(String[] args) {
    try {
      Path filePath = Paths.get("assets/duplicated-chars.txt");
      List<String> lines = Files.readAllLines(filePath);

      Path decryptedPath = Paths.get("assets/decrypted.txt");
      Files.write(decryptedPath, decrypt(lines));
      List<String> decryptedLines = Files.readAllLines(decryptedPath);
      display(decryptedLines);
      
    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }
  }

  public static List<String> decrypt(List<String> input) {
    ArrayList<String> decrypted = new ArrayList<>();
    for (String row : input) {
      String perLine = "";
      for (int i = 0; i < row.length() - 1; i++) {
        if (i == row.length() - 2) {
          perLine = perLine + row.charAt(i);
        } else{
          if (row.charAt(i) == row.charAt(i + 2) && row.charAt(i) == row.charAt(i + 3)) {
          } else if (row.charAt(i) == row.charAt(i + 1)) {
            perLine = perLine + row.charAt(i);
          }
        }
      }
      decrypted.add(perLine);
    }
    return decrypted;
  }

  public static void display(List<String> input) {
    for (String row : input) {
      System.out.println(row);
    }
  }
}
