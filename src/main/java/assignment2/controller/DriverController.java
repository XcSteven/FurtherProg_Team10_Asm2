package assignment2.controller;

import assignment2.model.Driver;
import assignment2.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {
    @Autowired
    private DriverService driverService;


    @RequestMapping(path = "/drivers", method = RequestMethod.GET)
    public List<Driver> getAllDrivers(){
        return driverService.getAllDriver();
    }

    @RequestMapping(path = "/drivers", method = RequestMethod.POST)
    public long addDriver(@RequestBody Driver driver) {
        return driverService.saveDriver(driver);
    }
}
