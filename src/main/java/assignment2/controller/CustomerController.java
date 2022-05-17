package assignment2.controller;

import assignment2.model.Customer;
import assignment2.service.CustomerService;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(path = "/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomer();
    }

    @RequestMapping(path = "/customers/{id}", method = RequestMethod.GET)
    public Customer getACustomer(@PathVariable long id) {
        return customerService.getACustomer(id);
    }

    @RequestMapping(path = "/customers", method = RequestMethod.POST)
    public long addCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public String updateCustomer(@RequestBody Customer newCustomer, @PathVariable long id) {
        return customerService.updateCustomer(newCustomer, id);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable long id){
        return  customerService.deleteACustomer(id);
    }

    @GetMapping("/customers/search/name/{key}")
    public List<Customer> searchCustomerByName(@PathVariable String key) {
        return customerService.searchCustomerByName(key);
    }

    @GetMapping("/customers/search/address/{key}")
    public List<Customer> searchCustomerByAddress(@PathVariable String key) {
        return customerService.searchCustomerByAddress(key);
    }

    @GetMapping("/customers/search/phone/{key}")
    public List<Customer> searchCustomerByPhone(@PathVariable String key) {
        return customerService.searchCustomerByPhone(key);
    }
}
