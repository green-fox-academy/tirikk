import java.util.ArrayList;

public class SharpieSet {
  ArrayList<Sharpie> list = new ArrayList<>();

  public void countUsable() {
    int usable = 0;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).inkAmount > 0) {
        usable++;
      }
    }
    System.out.println(usable);
  }

  public void add(Sharpie sharpie) {
    list.add(sharpie);
  }

  public void removeTrash() {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).inkAmount == 0) {
        list.remove(i);
      }
    }
  }
}
