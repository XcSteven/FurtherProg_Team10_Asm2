package assignment2.service;

import assignment2.model.Booking;
import assignment2.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class CustomerService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long saveCustomer(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
        return customer.getId();
    }

    public List<Customer> getAllCustomer() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        return criteria.list();
    }

    public Customer getACustomer(Long id) {
        return sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    public String updateCustomer(Customer newCustomer, Long id) {
        List<Customer> customerList = getAllCustomer();
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                sessionFactory.getCurrentSession().evict(customer);
                customer.setName(newCustomer.getName());
                customer.setAddress(newCustomer.getAddress());
                customer.setPhone(newCustomer.getPhone());
                sessionFactory.getCurrentSession().update(customer);
                return "Updated customer with id " + id;
            }
        }
        return "Can't find customer with id " + id;
    }

    public String deleteACustomer(Long id) {
        Customer customer = sessionFactory.getCurrentSession().get(Customer.class, id);
        if(customer != null) {
            sessionFactory.getCurrentSession().delete(customer);
            return "Deleted customer with id " + id;
        }

        return "Can't find customer with id " + id;
    }

    public List<Customer> searchCustomerByName(String name) {
        List<Customer> customerList = getAllCustomer();
        List<Customer> searchList = new ArrayList<>();
        for (Customer customer : customerList) {
            if(customer.getName().contains(name)) {
                searchList.add(customer);
            }
        }
        return searchList;
    }

    public List<Customer> searchCustomerByAddress(String add) {
        List<Customer> customerList = getAllCustomer();
        List<Customer> searchList = new ArrayList<>();
        for (Customer customer : customerList) {
            if(customer.getAddress().contains(add)) {
                searchList.add(customer);
            }
        }
        return searchList;
    }

    public List<Customer> searchCustomerByPhone(String phone) {
        List<Customer> customerList = getAllCustomer();
        List<Customer> searchList = new ArrayList<>();
        for (Customer customer : customerList) {
            if(customer.getPhone().contains(phone)) {
                searchList.add(customer);
            }
        }
        return searchList;
    }

    public Customer addBooking(Long id, Booking booking){
        getACustomer(id).setBookings(booking);
        return getACustomer(id);
    }
}
