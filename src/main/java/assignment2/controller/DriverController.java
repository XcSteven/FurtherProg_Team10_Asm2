package assignment2.controller;

import assignment2.model.Driver;
import assignment2.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {
    @Autowired
    private DriverService driverService;


    @RequestMapping(path = "/drivers", method = RequestMethod.GET)
    public List<Driver> getAllDrivers(){
        return driverService.getAllDriver();
    }

    @RequestMapping(path = "/drivers/{id}", method = RequestMethod.GET)
    public Driver getADriver(@PathVariable Long id) {
        return driverService.getADriver(id);
    }

    @RequestMapping(path = "/drivers", method = RequestMethod.POST)
    public Long addDriver(@RequestBody Driver driver) {
        return driverService.saveDriver(driver);
    }

    @PutMapping("/drivers/{id}")
    public String updateDriver(@RequestBody Driver newDriver, @PathVariable Long id) {
        return driverService.updateDriver(newDriver, id);
    }

    @DeleteMapping("/drivers/{id}")
    public String deleteDriver(@PathVariable Long id){
        return  driverService.deleteADriver(id);
    }
}
