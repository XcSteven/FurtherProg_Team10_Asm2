package assignment2.service;

import assignment2.model.Customer;
import assignment2.model.Student;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CustomerService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public long saveCustomer(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
        return customer.getId();
    }

    public List<Customer> getAllCustomer(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        return criteria.list();
    }
}
