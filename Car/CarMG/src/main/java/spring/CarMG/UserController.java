package spring.CarMG;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Request;
import spark.Response;
import java.util.List;

public class UserController {
	 private static final UserRepository userRepository = new UserRepository();
	    private static final ObjectMapper objectMapper = new ObjectMapper();

	    public static String getAllUsers(Request request, Response response) {
	        List<User> users = userRepository.getAllUsers();
	        response.type("application/json");
	        return toJson(users);
	    }

	    public static String getUserById(Request request, Response response) {
	        Long userId = Long.parseLong(request.params(":id"));
	        User user = userRepository.getUserById(userId);

	        if (user != null) {
	            response.type("application/json");
	            return toJson(user);
	        } else {
	            response.status(404); // Not Found
	            return "User not found";
	        }
	    }

	    public static String createUser(Request request, Response response) {
	        User user = fromJson(request.body(), User.class);
	        User createdUser = userRepository.createUser(user);

	        response.type("application/json");
	        response.status(201); 
	        return toJson(createdUser);
	    }

	    private static String toJson(Object object) {
	        try {
	            return objectMapper.writeValueAsString(object);
	        } catch (Exception e) {
	            throw new RuntimeException("Error converting object to JSON", e);
	        }
	    }

	    private static <T> T fromJson(String json, Class<T> clazz) {
	        try {
	            return objectMapper.readValue(json, clazz);
	        } catch (Exception e) {
	            throw new RuntimeException("Error converting JSON to object", e);
	        }
	    }

    

}
