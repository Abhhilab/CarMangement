package spring.CarMG;
import static spark.Spark.*;

public class CarMangement {

	public static void main(String[] args) {

        path("/api", () -> {

            path("/user", () -> {
                get("/getall", UserController::getAllUsers);
                get("/get/:id", UserController::getUserById);
                post("/create", UserController::createUser);
            });

            path("/car", () -> {
                get("/getall/:userId", CarController::getCarsByUserId);
                get("/get/:id", CarController::getCarById);
                post("/create", CarController::createCar);
            });


            path("/servicing", () -> {
                get("/getall/:carId", ServiceController::getAllServicingRecords);
                post("/create", ServiceController::createServicingRecord);
            });
        });
    }

}
