package InterfaceTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CarMain {
    public static void main(String[] args) {

        Car car1 = new Car("Mersedes", 300000);
        Car car2 = new Car("Tesla", 500000);
        Car car3 = new Car("Opel", 100000);
        Car car4 = new Car("Hyunday", 600000);

        ArrayList<Car> cars = new ArrayList<>(Arrays.asList(car1, car2, car3, car4));

        Collections.sort(cars);


    }
}
