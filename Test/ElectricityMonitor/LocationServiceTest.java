package ElectricityMonitor;

import org.junit.Test;
import org.mockito.Mockito;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.concurrent.CompletableFuture;
import com.google.gson.JsonObject;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class LocationServiceTest {

    @Test
    public void getUserLocationWithError() {

        HttpClient mockClient = Mockito.mock(HttpClient.class);

        when(mockClient.sendAsync(any(HttpRequest.class), any()))
                .thenReturn(CompletableFuture.failedFuture(new RuntimeException("Simulated error")));
        LocationService.setHttpClient(mockClient);
        JsonObject userLocation = LocationService.getUserLocation();
        assertNull(userLocation);
    }
}
