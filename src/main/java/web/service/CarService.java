package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> showCarsList(List<Car> carList, int count);
}
