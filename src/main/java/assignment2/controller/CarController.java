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
	public List<Car> getAllCars(){
		return carService.getAllCar();
	}
	
	@RequestMapping(path = "/cars", method = RequestMethod.POST)
	public long addCar(@RequestBody Car car) {
		return carService.saveCar(car);
	}

//	@RequestMapping(path = "/cars", method = RequestMethod.PUT)
//	public Car saveCar(@ModelAttribute Car car, @RequestBody Car req) {
//		car.setVIN(req.getVIN());
//		car.setMake(req.getMake());
//		car.setModel(req.getModel());
//		car.setColor(req.getColor());
//		car.setConvertible(req.isConvertible());
//		car.setRating((int) req.getRating());
//		car.setLicensePlate(req.getLicensePlate());
//		car.setRatePerKm((int) req.getRatePerKm());
//		return car;
//	}
	
	
}
