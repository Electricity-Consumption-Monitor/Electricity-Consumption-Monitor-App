package ElectricityMonitor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LocationService {

    private static final String ABSTRACT_API_KEY = "ebcc1dae7f6f441ebcebb06baf0ff9ca";
    private static final String ABSTRACT_API_URL = "https://ipgeolocation.abstractapi.com/v1/?api_key=ebcc1dae7f6f441ebcebb06baf0ff9ca";

    private static HttpClient httpClient = HttpClient.newHttpClient();

    public static JsonObject getUserLocation() {
        String url = String.format(ABSTRACT_API_URL, ABSTRACT_API_KEY);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return JsonParser.parseString(response.body()).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method for testing purposes to set a custom HttpClient
    public static void setHttpClient(HttpClient customClient) {
        httpClient = customClient;
    }
}
