package com.ecommerce.springbootbackend.repo;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.springbootbackend.model.Product;

public interface ProductManagerRepository extends CrudRepository<Product, String> {

}
