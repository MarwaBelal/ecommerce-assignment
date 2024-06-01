package com.ecommerce.springbootbackend.repo;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.springbootbackend.model.Customer;

public interface CustomerManagerRepository extends CrudRepository<Customer, String> {

}
