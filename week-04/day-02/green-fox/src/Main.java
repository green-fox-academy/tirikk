public class Main {
  public static void main(String[] args) {
    Person myPerson = new Person();
    myPerson.getGoal();
    myPerson.introduce();

    Person newPerson = new Person("John", 40, "male");
    newPerson.introduce();
  }
}
