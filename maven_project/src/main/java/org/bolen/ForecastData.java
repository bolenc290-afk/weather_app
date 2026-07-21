package org.bolen;


import java.util.List;

public record ForecastData(Forecast properties) {
    record Forecast(String units, String forecastGenerator, String generatedAt, String updateTime, String validTimes,
                    Elevation elevation, List<Period> periods) {
        record Elevation(String unitCode, Float value) {
        }

        record Period(int number, String name, String startTime, String endTime, Boolean isDaytime, int temperature,
                      String temperatureUnit, Probabilityofprecipitation probabilityofPrecipitation, String windSpeed,
                      String windDirection, String icon, String shortForecast, String detailedForecast) {
        }


        record Probabilityofprecipitation(String unitCode, int value) {
        }
    }
}