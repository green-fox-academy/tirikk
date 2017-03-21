import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("\"Hello, World!\"");
        System.out.println(123);

        boolean isMarried = true;
        String text = "majom";
        byte b = 24;
        short peaches = 1;
        int apples = 123;
        double pi = 3.14;

        System.out.println(apples);
        System.out.println(peaches++);
        System.out.println(peaches);

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(line);
    }
}
