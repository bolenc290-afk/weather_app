package org.bolen;


import okhttp3.OkHttpClient;

import java.io.IOException;


public class Main {
    static void main(String[] args) throws IOException {
        System.out.println("hello world");
        ForecastService forecastService = new ForecastService(new OkHttpClient() );
        ForecastData forecast = forecastService.getForecast();
        for (ForecastData.Forecast.Period period : forecast.properties().periods()) {
            System.out.println("---------------------------------");
            System.out.println(period.name());
            System.out.println("Temperature: " + period.temperature());
        }
    }
}



