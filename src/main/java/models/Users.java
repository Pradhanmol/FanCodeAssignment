package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
    // Unique identifier for the user
    public int id;

    // Name of the user
    public String name;

    // Address details of the user
    public Address address;

    // Nested static class representing the user's address
    public static class Address {
        // Street name of the user's address
        public String street; // Include missing fields

        // Suite or apartment number of the user's address
        public String suite;

        // City of the user's address
        public String city;

        // Zipcode of the user's address
        public String zipcode;

        // Geographical coordinates of the user's address
        public Geo geo;
    }

    // Nested static class representing geographical coordinates
    public static class Geo {
        // Latitude of the geographical location
        public String lat;

        // Longitude of the geographical location
        public String lng;
    }
}