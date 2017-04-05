import java.util.ArrayList;

public class Sum {

  public int sum(ArrayList<Integer> list) {
    int sum = 0;
    for (int num : list) {
      sum += num;
    }
    return sum;
  }
}
