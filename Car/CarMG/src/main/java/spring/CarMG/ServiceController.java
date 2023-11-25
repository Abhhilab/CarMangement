package spring.CarMG;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Request;
import spark.Response;
import java.util.List;

public class ServiceController {
	private static final ServiceRepository servicingRepository = new ServiceRepository();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String getAllServicingRecords(Request request, Response response) {
        Long carId = Long.parseLong(request.params(":carId"));
        List<Servicing> servicings = servicingRepository.getAllServicingRecords(carId);

        response.type("application/json");
        return toJson(servicings);
    }

    public static String createServicingRecord(Request request, Response response) {
        Servicing servicing = fromJson(request.body(), Servicing.class);
        Servicing createdServicing = servicingRepository.createServicingRecord(servicing);

        response.type("application/json");
        response.status(201);
        return toJson(createdServicing);
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
