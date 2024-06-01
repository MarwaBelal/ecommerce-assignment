package com.ecommerce.springbootbackend.repo;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.springbootbackend.model.Order;

public interface OrderManagerRepository extends CrudRepository<Order, String> {

}
