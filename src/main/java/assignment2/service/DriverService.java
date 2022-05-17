package assignment2.service;

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

    public List<Driver> getAllDriver() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Driver.class);
        return criteria.list();
    }

    public Driver getADriver(Long id) {
        return sessionFactory.getCurrentSession().get(Driver.class, id);
    }

    public String updateDriver(Driver newDriver, Long id) {
        List<Driver> driverList = getAllDriver();
        for (Driver driver : driverList){
            if (driver.getId() == id) {
                sessionFactory.getCurrentSession().evict(driver);
                driver.setLicense(newDriver.getLicense());
                driver.setPhone(newDriver.getPhone());
                driver.setRating(newDriver.getRating());
                sessionFactory.getCurrentSession().update(driver);
                return "Updated driver with id " + id;
            }
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
}
