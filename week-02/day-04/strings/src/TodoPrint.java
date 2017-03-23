public class TodoPrint {
  public static void main(String... args){
    String todoText = " - Buy milk\n";
    // Add "My todo:" to the beginning of the todoText
    // Add " - Download games" to the end of the todoText
    // Add " - Diablo" to the end of the todoText but with indention

    // Expected outpt:

    // My todo:
    //  - Buy milk
    //  - Download games
    //      - Diablo

    todoText = todoText.concat(" - Download games\n     - Diablo");
    String title = "My todo:\n";
    todoText = title.concat(todoText);
    System.out.println(todoText);
  }
}