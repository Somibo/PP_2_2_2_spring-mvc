package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {
    private final static List<Car> cars = new ArrayList<>(Arrays.asList(
            new Car("a", 1, "ffffff"),
            new Car("b", 10, "000000"),
            new Car("c", 1000, "00ff00"),
            new Car("d", 10000, "66ff00"),
            new Car("s", 100000, "ffff00")
    ));

    public List<Car> getCars(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
