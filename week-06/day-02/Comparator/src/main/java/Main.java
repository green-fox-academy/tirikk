import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    ArrayList<Mentor> mentors = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      mentors.add(new Mentor());
      students.add(new Student());
    }
    System.out.println(students.toString());
    Collections.sort(students);
    System.out.println(students.toString());

    System.out.println();

    System.out.println(mentors.toString());
    Collections.sort(mentors, new LevelComparator());
    System.out.println(mentors.toString());
  }


}
