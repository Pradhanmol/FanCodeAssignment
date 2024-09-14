package utils;

public class GeoUtils {

    public static boolean isInFanCodeCity(String lat, String lng) {
        // Convert latitude and longitude from String to double
        double latitude = Double.parseDouble(lat);
        double longitude = Double.parseDouble(lng);

        // Check if the latitude and longitude are within the range for FanCode city
        return latitude >= -40 && latitude <= 5 && longitude >= 5 && longitude <= 100;
    }
}