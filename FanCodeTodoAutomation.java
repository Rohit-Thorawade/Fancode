import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

import java.util.HashMap;
import java.util.List;

public class FanCodeTodoAutomation {

    public static void main(String[] args) {

    	// Step 1: Base URI
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";

        // Step 2: Fetch Users from /users
        Response usersResponse = RestAssured.get("/users");

        JsonPath usersJson = usersResponse.jsonPath();

        // Filter users belonging to FanCode city based on latitude and longitude
        List<HashMap<String, Object>> users = usersJson.getList("");
        
        System.out.println("Total Users: " + users.size());

        for (HashMap<String, Object> user : users) {

        	// Extract user address details
            @SuppressWarnings("unchecked")
			HashMap<String, Object> address = (HashMap<String, Object>) user.get("address");
            
            
            @SuppressWarnings("unchecked")
			HashMap<String, String> geo = (HashMap<String, String>) address.get("geo");

            // Parse latitude and longitude
            double latitude = Double.parseDouble(geo.get("lat"));

            double longitude = Double.parseDouble(geo.get("lng"));

            // Check if user belongs to FanCode City
            if (latitude > -40 && latitude < 5 && longitude > 5 && longitude < 100) {
                int userId = (Integer) user.get("id");
                System.out.println("User ID: " + userId + " belongs to FanCode City");

                // Step 3: Fetch Todos for the user
                Response todosResponse = RestAssured.get("/todos?userId=" + userId);
              
                JsonPath todosJson = todosResponse.jsonPath();
                
                List<HashMap<String, Object>> todos = todosJson.getList("");

                // Calculate completed tasks
                int totalTasks = todos.size();

                int completedTasks = 0;

                for (HashMap<String, Object> task : todos)
                {
                    boolean isCompleted = (Boolean) task.get("completed");

                    if (isCompleted) {
                        completedTasks++;
                    }
                }

                // Calculate completion percentage
                double completionPercentage = ((double) completedTasks / totalTasks) * 100;

                System.out.println("User ID: " + userId + " Task Completion: " + completionPercentage + "%");

                // Step 4: Validate the condition
                if (completionPercentage > 50)
                {

                	System.out.println("User ID: " + userId + " satisfies the condition");
                } 
                
                else 
                {
                    System.out.println("User ID: " + userId + " does NOT satisfy the condition");
                }
            }
        }
    }
}
