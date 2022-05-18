package assignment2.service;

import assignment2.model.Car;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CarService {
    @Autowired
        private SessionFactory sessionFactory;

        public void setSessionFactory(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }
    
    public Long saveCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
        return car.getId();
    }

    public List<Car> getAllCar() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Car.class);
        return criteria.list();
    }

    public Car getACar(Long id) {
        return sessionFactory.getCurrentSession().get(Car.class, id);
    }

    public String updateCar(Car newCar, Long id) {
        List<Car> carList = getAllCar();
        for (Car car : carList) {
            if (car.getId() == id) {
                sessionFactory.getCurrentSession().evict(car);
                car.setVehicleId(newCar.getVehicleId());
                car.setMake(newCar.getMake());
                car.setModel(newCar.getModel());
                car.setColor(newCar.getColor());
                car.setConvertible(newCar.isConvertible());
                car.setRating(newCar.getRating());
                car.setLicensePlate(newCar.getLicensePlate());
                car.setRatePerKm((newCar.getRatePerKm()));
                sessionFactory.getCurrentSession().update(car);
                return "Updated car with id " + id;
            }
        }
        return "Can't find car with id " + id;
    }

    public String deleteACar(Long id) {
        Car car = sessionFactory.getCurrentSession().get(Car.class, id);
        if(car != null) {
            sessionFactory.getCurrentSession().delete(car);
            return "Deleted car with id " + id;
        }

        return "Can't find car with id " + id;
    }
}
