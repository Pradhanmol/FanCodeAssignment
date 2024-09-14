package config;

import io.restassured.RestAssured;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

    // Declaring the object of Properties class to read configuration details
    static Properties props;

    // Define the path to the properties file
    String path = System.getProperty("user.dir") + "/src/main/resources/config.properties";

    // Constructor to initialize the Properties object and read the configuration file
    public Base() {
        // Initialize the Properties object
        try {
            props = new Properties();
            // Use FileInputStream to read the properties file
            FileInputStream fis = new FileInputStream(path);
            // Load properties from the file
            props.load(fis);
        } catch (IOException e) {
            // Print stack trace if there is an issue with file reading
            e.printStackTrace();
        }
    }

    public static Base setup() {
        Base base = new Base();
        String baseUrl = base.getUrl();
        if (baseUrl != null) {
            RestAssured.baseURI = baseUrl;
        } else {
            throw new RuntimeException("Base URL not found in the properties file.");
        }
        return base;
    }

    // Method to get the base URL from the properties file
    public String getUrl() {
        if (props == null) {
            throw new IllegalStateException("Properties have not been initialized.");
        }
        return props.getProperty("url");
    }

    // Method to get the To-Do endpoint from the properties file
    public String getTodoEndPoint() {
        if (props == null) {
            throw new IllegalStateException("Properties have not been initialized.");
        }
        return props.getProperty("todoEndPoint");
    }

    // Method to get the User endpoint from the properties file
    public String getUserEndPoint() {
        if (props == null) {
            throw new IllegalStateException("Properties have not been initialized.");
        }
        return props.getProperty("userEndPoint");
    }
}