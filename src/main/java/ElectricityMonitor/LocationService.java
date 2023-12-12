package ElectricityMonitor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LocationService {

    private static final String IPSTACK_API_KEY = "2e0428321da7b6bc992de51451bd6c1b";
    private static final String IPSTACK_URL = "http://api.ipstack.com/check?access_key=%s";

    private static HttpClient httpClient = HttpClient.newHttpClient();

    public static JsonObject getUserLocation() {
        String url = String.format(IPSTACK_URL, IPSTACK_API_KEY);
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
