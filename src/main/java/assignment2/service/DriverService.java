package assignment2.service;

import assignment2.model.Car;
import assignment2.model.Driver;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DriverService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long saveDriver(Driver driver) {
        sessionFactory.getCurrentSession().save(driver);
        return driver.getId();
    }


    public List<Driver> getAllDriver(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Driver.class);
        return criteria.list();
    }

    public Driver getADriver(Long id) {
        return sessionFactory.getCurrentSession().get(Driver.class, id);
    }

    public String updateDriver(Driver newDriver, Long id) {
//        }
        Driver driver = sessionFactory.getCurrentSession().get(Driver.class, id);
        if(driver != null) {
            sessionFactory.getCurrentSession().evict(driver);
                driver.setLicense(newDriver.getLicense());
                driver.setPhone(newDriver.getPhone());
                driver.setRating(newDriver.getRating());
                driver.setCar(newDriver.getCar());
                sessionFactory.getCurrentSession().update(driver);
            return "Updated driver with id " + id;
        }

        return "Can't find driver with id " + id;
    }

    public String deleteADriver(Long id) {
        Driver driver = sessionFactory.getCurrentSession().get(Driver.class, id);
        if(driver != null) {
            sessionFactory.getCurrentSession().delete(driver);
            return "Deleted driver with id " + id;
        }

        return "Can't find driver with id " + id;
    }

    public String driverChooseCar(Long driverId, Long carId) {
        Car car = sessionFactory.getCurrentSession().get(Car.class, carId);
        Driver driver = sessionFactory.getCurrentSession().get(Driver.class, driverId);
        if(car != null) {
            if(car.getDriverId() != null){
                if(getADriver(car.getDriverId()).getId() == driverId){
                    return "Driver " + driverId + " already selected this car (Car Id: " + carId + ")";
                }
                else if(getADriver(car.getDriverId()).getId() != driverId) {
                    return "This car (Car Id: " + carId + ") has been selected by another driver";
                }
            }
            if(car.getDriverId() == null){
                driver.setCar(car);
                car.setDriverId(driver.getId());
                sessionFactory.getCurrentSession().update(driver);
                sessionFactory.getCurrentSession().update(car);
                return sessionFactory.getCurrentSession().get(Driver.class, driverId).toString();
            }
        }

        return null;
    }
}
