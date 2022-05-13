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
	
	public long saveCar(Car car) {
		sessionFactory.getCurrentSession().save(car);
		return car.getId();
	}
	
	public List<Car> getAllCar(){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Car.class);
		return criteria.list();
	}

	public long updateCar(Car car){
		sessionFactory.getCurrentSession().update(car);
		return car.getId();
	}

}
