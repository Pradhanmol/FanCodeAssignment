package api;

import config.Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Users;

public class UserApi {

    public Base base;

    // Constructor for the UserApi class
    public UserApi() {
        // Initialize the base configuration by calling the setup method from the config.Base class
        // Initialize the userEndpoint variable after setup
        this.base = config.Base.setup();
        this.userEndpoint = base.getUserEndPoint();
    }
    // Endpoint for the Users API, stored in a final variable as it does not change
    private String userEndpoint;

    // Method to get the response from the Users API
    public Response getUsers() {
        // Use RestAssured to send a GET request to the userEndpoint and return the response
        return RestAssured.get(userEndpoint);
    }

    // Method to get the Users data as an array of Users objects
    public Users[] getUsersAsObjects() {
        // Convert the response from getUsers() method into an array of Users objects and return it
        return getUsers().as(Users[].class);
    }
}