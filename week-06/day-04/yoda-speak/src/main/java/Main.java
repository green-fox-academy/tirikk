import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter a string");
    String string = scanner.nextLine();

    try {
      HttpResponse<String> response = Unirest.get("https://yoda.p.mashape.com/yoda?sentence=" + string.replace(" ",
              "+"))
              .header("X-Mashape-Key", "7xu0UJuSasmshpNhmLxirFzPoYHxp1Wf8CbjsnNR4O5fFCGYKZ")
              .header("Accept", "text/plain")
              .asString();
      System.out.println(response.getBody());
    } catch (UnirestException e) {
      e.printStackTrace();
    }
  }
}
