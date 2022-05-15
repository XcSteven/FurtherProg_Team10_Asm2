package assignment2.service;

import assignment2.model.Customer;
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

    public Customer getACustomer(long id) {
        return sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    public String updateCustomer(Customer newCustomer, long id) {
        List<Customer> customerList = getAllCustomer();
        for (Customer customer : customerList){
            if (customer.getId() == id){
                sessionFactory.getCurrentSession().evict(customer);
                customer.setName(newCustomer.getName());
                sessionFactory.getCurrentSession().update(customer);
                return "Updated customer with id " + id;
            }
        }
        return "Can't find customer with id " + id;
    }

    public String deleteACustomer(long id){
        Customer customer = sessionFactory.getCurrentSession().get(Customer.class, id);
        if(customer != null){
            sessionFactory.getCurrentSession().delete(customer);
            return "Deleted customer with id " + id;
        }

        return "Can't find customer with id " + id;
    }
}
