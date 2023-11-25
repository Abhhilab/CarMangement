package spring.CarMG;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {

    private static List<Car> cars = new ArrayList<>();

    public List<Car> getAllCars() {
        return cars;
    }

    public Car getCarById(Long carId) {
        for (Car car : cars) {
            if (car.getId().equals(carId)) {
                return car;
            }
        }
        return null;
    }

    public List<Car> getCarsByUserId(Long userId) {
        return cars.stream()
                .filter(car -> car.getId().equals(userId))
                .collect(Collectors.toList());
    }

    public Car createCar(Car car) {
        Long nextId = generateNextCarId();
        car.setId(nextId);
        cars.add(car);
        return car;
    }

    private Long generateNextCarId() {
        return System.currentTimeMillis();
    }
}