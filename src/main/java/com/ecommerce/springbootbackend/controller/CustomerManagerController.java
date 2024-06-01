package com.ecommerce.springbootbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.springbootbackend.model.Customer;
import com.ecommerce.springbootbackend.repo.CustomerManagerRepository;

@RestController
@RequestMapping("/customermanager")
public class CustomerManagerController {

    @Autowired
    CustomerManagerRepository repo;

        // Add Customer REST API
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        Customer savedResult = repo.save(customer);
        return savedResult;
    }

        // Remove Customer by ID REST API
    @DeleteMapping("/removeCustomer/{id}")
    public Iterable<Customer> removeCustomer(@PathVariable("id") String customerId) {
        repo.deleteById(customerId);
        return repo.findAll();
    }

        // Get All Customers REST API
    @GetMapping("/getCustomers")
    public Iterable<Customer> viewAllCustomers() {
        return repo.findAll();
    }
}
