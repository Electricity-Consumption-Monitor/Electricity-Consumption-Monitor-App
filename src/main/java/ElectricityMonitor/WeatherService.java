package ElectricityMonitor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherService {

    private static final String API_KEY = "533e1baa54a8cf659fed8ec2b8a060f5";
    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public static JsonObject getCurrentWeather(String city) {
        String url = String.format(WEATHER_URL, city, API_KEY);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return JsonParser.parseString(response.body()).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}