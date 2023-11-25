package spring.CarMG;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceRepository {
	 private static List<Servicing> servicingRecords = new ArrayList<>();

	    public List<Servicing> getAllServicingRecords(Long carId) {
	        return servicingRecords.stream()
	                .filter(servicing -> servicing.getId().equals(carId))
	                .collect(Collectors.toList());
	    }

	    public Servicing createServicingRecord(Servicing servicing) {
	        Long nextId = generateNextServicingId();
	        servicing.setId(nextId);
	        servicingRecords.add(servicing);
	        return servicing;
	    }

	    private Long generateNextServicingId() {
	        return System.currentTimeMillis();
	    }

}
