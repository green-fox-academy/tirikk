
public class Cuboid {
  public static void main(String[] args) {

    double edgeA = 2;
    double edgeB = 5;
    double edgeC = 9;

    double surface = 2*(edgeA*edgeB+edgeA*edgeC+edgeB*edgeC);
    double volume = edgeA*edgeB*edgeC;

    System.out.println("Surface Area: " + (int)surface);
    System.out.println("Volume: " + (int)volume);
  }
}
