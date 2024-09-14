package api;

import config.Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Todo;

public class TodoApi {

    public Base base;

    // Constructor for the TodoApi class
    public TodoApi() {
        // Initialize the base configuration by calling the setup method from the config.Base class
        this.base = config.Base.setup();
        this.todoEndPoint = base.getTodoEndPoint();
    }

    // Endpoint for the To-Do API, stored in a final variable as it does not change
    private final String todoEndPoint;

    // Method to get the response from the To-Do API
    public Response getTodos() {
        // Use RestAssured to send a GET request to the todoEndPoint and return the response
        return RestAssured.get(todoEndPoint);
    }

    // Method to get the To-Do data as an array of Todo objects
    public Todo[] getTodosAsObjects() {
        // Convert the response from getTodos() method into an array of Todo objects and return it
        return getTodos().as(Todo[].class); // Convert response to Todo array objects
    }
}