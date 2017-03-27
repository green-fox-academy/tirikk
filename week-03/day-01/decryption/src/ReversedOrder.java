import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedOrder {
  public static void main(String[] args) {
    try {
      Path filePath = Paths.get("assets/reversed-order.txt");
      List<String> lines = Files.readAllLines(filePath);

      Path reversedPath = Paths.get("assets/right-order.txt");
      Files.write(reversedPath, reverse(lines));
      List<String> reversedOrder = Files.readAllLines(reversedPath);
      display(reversedOrder);

    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }
  }

  public static List<String> reverse(List<String> listToReverse) {
    ArrayList<String> reversed = new ArrayList<>();
    for (int i = listToReverse.size() - 1; i >= 0; i--) {
      reversed.add(listToReverse.get(i));
    }
    return reversed;
  }

  public static void display(List<String> listToDisplay) {
    for (String row : listToDisplay) {
      System.out.println(row);
    }
  }
}
