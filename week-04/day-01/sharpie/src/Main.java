public class Main {
  public static void main(String[] args) {
    Sharpie greenSharpie = new Sharpie("green", 20);
    greenSharpie.use();
    System.out.println(greenSharpie.inkAmount);
  }
}
