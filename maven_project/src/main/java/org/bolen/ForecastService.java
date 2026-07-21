package org.bolen;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ForecastService {
    OkHttpClient okHttpClient;
    public ForecastService( OkHttpClient okHttpClient){
        this.okHttpClient = okHttpClient;
    }
    public ForecastData getForecast() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MediaType JSON = MediaType.get("application/json");



        Request request = new Request.Builder()
                .url("https://api.weather.gov/gridpoints/RAH/69,62/forecast")
                .get()
                .build();
        try (
                Response response = okHttpClient.newCall(request).execute()) {
            String returnValue = response.body().string();
            ForecastData forecast = objectMapper.readValue(returnValue, ForecastData.class);
            System.out.println(forecast);
            return forecast;
        }
    }
}
