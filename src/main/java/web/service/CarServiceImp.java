package web.service;

import org.springframework.stereotype.Controller;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarServiceImp implements CarService {
    private List<Car> carList = new ArrayList<>();

    public CarServiceImp() {
        carList.add(new Car("Lada", "White", 118));
        carList.add(new Car("Mercedes", "White", 350));
        carList.add(new Car("BMW", "Black", 366));
        carList.add(new Car("Nissan", "Yellow", 189));
        carList.add(new Car("Bugatti", "Blue", 999));
    }

    @Override
    public List<Car> getCars(int count) {
        return carList.stream().limit(count < 0 ? carList.size() : count).toList();
    }
}
