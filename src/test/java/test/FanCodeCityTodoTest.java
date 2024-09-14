package test;

import api.TodoApi;
import api.UserApi;
import config.Base;
import models.Todo;
import models.Users;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.GeoUtils;

import java.util.HashMap;
import java.util.Map;
@Listeners({TestListenerAdapter.class})
public class FanCodeCityTodoTest {

    UserApi userApi;
    TodoApi todoApi;

    @BeforeClass
    public void setUp() {
        Base.setup(); // Set the base URL before the tests
        userApi = new UserApi();
        todoApi = new TodoApi();
    }

    @Test
    public void testUsersFromFanCodeCityTodoCompletion() {
        // Fetch users and filter for TanCode city users
        Users[] users = userApi.getUsersAsObjects();
        Map<Integer, String> tanCodeUsers = new HashMap<>();
        for (Users user : users) {
            if (GeoUtils.isInFanCodeCity(user.address.geo.lat, user.address.geo.lng)) {
                tanCodeUsers.put(user.id, user.name);
            }
        }

        // Fetch all todos
        Todo[] todos = todoApi.getTodosAsObjects();
        Map<Integer, Integer[]> userTodoCompletion = new HashMap<>();

        // Track each user's completed and total todos
        for (Todo todo : todos) {
            if (tanCodeUsers.containsKey(todo.userId)) {
                userTodoCompletion.putIfAbsent(todo.userId, new Integer[]{0, 0});
                Integer[] counts = userTodoCompletion.get(todo.userId);
                counts[1]++; // total todos
                if (todo.completed) {
                    counts[0]++; // completed todos
                }
            }
        }

        // Check completion percentage for each user
        for (Map.Entry<Integer, Integer[]> entry : userTodoCompletion.entrySet()) {
            int userId = entry.getKey();
            Integer[] counts = entry.getValue();
            double completionPercentage = (double) counts[0] / counts[1] * 100;
            System.out.println("User: " + tanCodeUsers.get(userId) + " completed " + completionPercentage + "% of tasks.");
            Assert.assertTrue(completionPercentage > 50, "User " + tanCodeUsers.get(userId) + " has less than 50% tasks completed.");
        }
    }
}