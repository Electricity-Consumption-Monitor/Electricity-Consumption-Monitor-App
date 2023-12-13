package ElectricityMonitor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import com.google.gson.JsonObject;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class WeatherServiceTest {

    @Test
    public void getCurrentWeather_HttpRequestFails_ReturnsNull() {
        HttpClient mockClient = mock(HttpClient.class);
        WeatherService.setHttpClient(mockClient);


        CompletableFuture<HttpResponse<String>> mockFuture = new CompletableFuture<>();
        mockFuture.completeExceptionally(new RuntimeException("Simulated HTTP request failure"));
        JsonObject weatherData = WeatherService.getCurrentWeather("TestCity");
        assertNull(weatherData);
    }
}
