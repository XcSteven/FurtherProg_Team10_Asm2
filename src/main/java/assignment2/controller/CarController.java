package assignment2.controller;

import assignment2.model.Car;
import assignment2.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(path = "/cars", method = RequestMethod.GET)
    public List<Car> getAllCars() {
        return carService.getAllCar();
    }

    @RequestMapping(path = "/cars/{id}", method = RequestMethod.GET)
    public Car getACar(@PathVariable long id) {
        return carService.getACar(id);
    }

    @RequestMapping(path = "/cars", method = RequestMethod.POST)
    public long addCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @PutMapping("/cars/{id}")
    public String updateCar(@RequestBody Car newCar, @PathVariable long id) {
        return carService.updateCar(newCar, id);
    }

    @DeleteMapping("/cars/{id}")
    public String deleteCar(@PathVariable long id){
        return  carService.deleteACar(id);
    }

}

