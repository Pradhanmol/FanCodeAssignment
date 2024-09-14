package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Todo {
    // ID of the user associated with this To-Do item
    public int userId;

    // Indicates whether the To-Do item is completed
    public boolean completed;
}