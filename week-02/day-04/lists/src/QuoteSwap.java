import java.util.*;

public class QuoteSwap{
  public static void main(String... args){
    ArrayList<String> list = new ArrayList<String>(Arrays.asList("What", "I", "do", "create,", "I", "cannot", "not", "understand."));

    // Accidentally I messed up this quote from Richard Feynman.
    // Two words are out of place
    // Your task is to fix it by swapping the right words with code

    // Also, print the sentence to the output with spaces in between.

    int doIndex = list.indexOf("do");
    int cannotIndex = list.indexOf("cannot");

    list.set(doIndex, "cannot");
    list.set(cannotIndex, "do");

    String str = String.join(" ", list);

    System.out.println(str);
  }
}