import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestApiClient {

    public static void main(String[] args) {

        try {
            String name = "michael";
            String apiUrl = "https://api.agify.io/?name=" + name;

            System.out.println("Connecting to API...");
            System.out.println("URL: " + apiUrl);

            HttpClient client = HttpClient.newBuilder()
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            System.out.println("Response Code: " + response.statusCode());

            String body = response.body();

            System.out.println("\nRaw JSON Response:");
            System.out.println(body);

        } catch (Exception e) {
            System.out.println("Error occurred:");
            e.printStackTrace();
        }
    }
}