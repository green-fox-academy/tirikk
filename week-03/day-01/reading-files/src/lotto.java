import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lotto {
  public static void main(String[] args) {
    try {
      Path filePath = Paths.get("assets/otos.csv");
      List<String> lines = Files.readAllLines(filePath);
      System.out.println(mostCommon(toMap(getNumbers(lines))));
    } catch (Exception e) {
      System.out.println("Uh-oh, an error happend: " + e.getClass());
    }
  }

  public static ArrayList<Integer> getNumbers(List<String> input) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < input.size(); i++) {
      String[] perLine = input.get(i).split(";");
      for (int j = perLine.length - 5; j < perLine.length; j++) {
        list.add(Integer.parseInt(perLine[j]));
      }
    }
    return list;
  }

  public static HashMap<Integer, Integer> toMap(ArrayList<Integer> input) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i : input) {
      if (!map.containsKey(i)) {
        map.put(i, 1);
      } else {
        map.put(i, map.get(i) + 1);
      }
    }
    return map;
  }

  public static HashMap<Integer, Integer> mostCommon(HashMap<Integer, Integer> input) {
    HashMap<Integer, Integer> maxMap = new HashMap<>();
    for (int i = 5; i > 0; i--) {
      int max = 0;
      int number = 0;
      for (int key : input.keySet()) {
        if (!maxMap.containsKey(key) && input.get(key) > max) {
          max = input.get(key);
          number = key;
        }
      }
      maxMap.put(number, max);
    }
    return maxMap;
  }
}
