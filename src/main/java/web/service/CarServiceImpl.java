package web.service;

import web.model.Car;

import java.util.List;

public class CarServiceImpl implements CarService {

    @Override
    public List<Car> showCarsList(List<Car> carList, int count) {
        if (count == 0 || count > 5) {
            return carList;
        }
        return carList.stream().limit(count).toList();
    }
}
