package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    private CarService carService;

    public CarsController() {
        this.carService = new CarServiceImpl();
    }

    @GetMapping("/cars")    //  http://localhost:8080/cars
    public String cars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car("BMW", "X5", 25));
        carsList.add(new Car("Nissan", "X-Trail", 50));
        carsList.add(new Car("Ferrari", "288 GTO", 75));
        carsList.add(new Car("Porsche", "Panamera", 100));
        carsList.add(new Car("Ford", "Mustang", 125));
        carsList = carService.showCarsList(carsList, count);
        model.addAttribute("carsList", carsList);
        return "cars";

    }
}