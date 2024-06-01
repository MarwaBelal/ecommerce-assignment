package com.ecommerce.springbootbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.springbootbackend.model.Order;
import com.ecommerce.springbootbackend.model.Product;
import com.ecommerce.springbootbackend.repo.OrderManagerRepository;

@RestController
@RequestMapping("/ordermanager")
public class OrderManagerController {

    @Autowired
    OrderManagerRepository repo;

    // Add Order REST API
    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order) {
        List<Product> productList = order.getProducts();
        double totalOrderAmount = order.calculateTotalAmount(productList);
        order.setTotalAmount(totalOrderAmount);
        Order savedResult = repo.save(order);
        return savedResult;
    }

    // Delete Order by ID REST API
    @DeleteMapping("/removeOrder/{id}")
    public Iterable<Order> removeOrder(@PathVariable("id") String orderId) {
        repo.deleteById(orderId);
        return repo.findAll();
    }

    // Get All Orders REST API
    @GetMapping("/getOrders")
    public Iterable<Order> viewAllOrders() {
        return repo.findAll();
    }
}
