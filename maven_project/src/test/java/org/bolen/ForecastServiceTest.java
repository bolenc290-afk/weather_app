package org.bolen;

import okhttp3.OkHttpClient;
import org.junit.Test;

import java.io.IOException;

public class ForecastServiceTest {
    @Test
    public void test_display_forecast() throws IOException {
        ForecastService displaytest = new ForecastService(new OkHttpClient());
        ForecastData forecastData = displaytest.getForecast();

    }
}
