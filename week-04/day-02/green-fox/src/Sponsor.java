public class Sponsor extends Person {
  private String company;
  private int hiredStudents;

  public void introduce () {
    System.out.println("Hi, I'm " + getName() + ", a " + getAge() + " year old " + getGender() + " who represents " +
            company + " and hired " + hiredStudents + " so far.");
  }

  public void hire() {
    hiredStudents++;
  }

  public void getgoal() {
    System.out.println("Hire brilliant junior software developers.");
  }

  Sponsor(String name, int age, String gender, String company) {
    super(name, age, gender);
    this.company = company;
    hiredStudents = 0;
  }

  Sponsor() {
    super();
    company = "Google";
    hiredStudents = 0;
  }
}
