package spring.CarMG;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Request;
import spark.Response;
import java.util.List;

public class CarController {
	 private static final CarRepository carRepository = new CarRepository();
	    private static final ObjectMapper objectMapper = new ObjectMapper();

	    public static String getAllCars(Request request, Response response) {
	        List<Car> cars = carRepository.getAllCars();
	        response.type("application/json");
	        return toJson(cars);
	    }

	    public static String getCarById(Request request, Response response) {
	        Long carId = Long.parseLong(request.params(":id"));
	        Car car = carRepository.getCarById(carId);

	        if (car != null) {
	            response.type("application/json");
	            return toJson(car);
	        } else {
	            response.status(404); // Not Found
	            return "Car not found";
	        }
	    }

	    public static String getCarsByUserId(Request request, Response response) {
	        Long userId = Long.parseLong(request.params(":userId"));
	        List<Car> cars = carRepository.getCarsByUserId(userId);

	        response.type("application/json");
	        return toJson(cars);
	    }

	    public static String createCar(Request request, Response response) {
	        Car car = fromJson(request.body(), Car.class);
	        Car createdCar = carRepository.createCar(car);

	        response.type("application/json");
	        response.status(201); 
	        return toJson(createdCar);
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
