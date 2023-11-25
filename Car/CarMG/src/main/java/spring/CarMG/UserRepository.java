package spring.CarMG;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	 private static List<User> users = new ArrayList<>();

	    public List<User> getAllUsers() {
	        return users;
	    }

	    public User getUserById(Long userId) {
	        for (User user : users) {
	            if (user.getId().equals(userId)) {
	                return user;
	            }
	        }
	        return null;
	    }

	    public User createUser(User user) {
	        Long nextId = generateNextUserId();
	        user.setId(nextId);
	        users.add(user);
	        return user;
	    }

	    private Long generateNextUserId() {
	        return System.currentTimeMillis();
	    }
}