import java.util.Comparator;

public class Mentor extends Person {
  private String level;

  public String getLevel() {
    return level;
  }

  public void getGoal() {
    System.out.println("My goal is: Educate brilliant junior software developers");
  }

  public void introduce() {
    System.out.println("Hi, I'm " + getName() + ", a " + getAge() + " year old " + getGender() + " " + level + " " +
            "mentor.");
  }

  Mentor() {
    super();
    String[] levels = {"junior", "intermediate", "senior"};
    level = levels[(int) (Math.random() * levels.length)];
  }

  Mentor(String name, int age, String gender, String level) {
    super(name, age, gender);
    this.level = level;
  }

  @Override
  public String toString() {
    return getName() + " " + level;
  }
}

class LevelComparator implements Comparator<Mentor> {

  @Override
  public int compare(Mentor o1, Mentor o2) {

    if (o1.getLevel().equals("junior")) {
      return -1;
    } else if (o1.getLevel().equals("senior")) {
      return 1;
    } else if (o1.getLevel().equals("intermediate") && o2.getLevel().equals("junior")) {
      return 1;
    } else {
      return -1;
    }
  }
}
