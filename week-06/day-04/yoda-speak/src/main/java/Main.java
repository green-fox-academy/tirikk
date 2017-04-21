import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {
  public static void main(String[] args) {
    try {
      HttpResponse<String> response = Unirest.get("https://yoda.p.mashape.com/yoda?sentence=You+will+learn+how+to+speak+like+me+someday.++Oh+wait.")
              .header("X-Mashape-Key", "7xu0UJuSasmshpNhmLxirFzPoYHxp1Wf8CbjsnNR4O5fFCGYKZ")
              .header("Accept", "text/plain")
              .asString();
      System.out.println(response.getBody());
    } catch (UnirestException e) {
      e.printStackTrace();
    };
  }
}
