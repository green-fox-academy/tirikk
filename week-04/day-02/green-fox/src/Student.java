public class Student extends Person {
  private String previousOrganization;
  private int skippedDays;

  @Override
  public void getGoal() {
    System.out.println("Be a junior software developer");
  }

  @Override
  public void introduce() {
    System.out.println("Hi, I'm " + getName() + ", a " + getAge() + " year old " + getGender() + " from " +
            previousOrganization + " who skipped " + skippedDays + " days from the course already.");
  }

  public void skipDays(int numberOFDays) {
    skippedDays += numberOFDays;
  }

}
