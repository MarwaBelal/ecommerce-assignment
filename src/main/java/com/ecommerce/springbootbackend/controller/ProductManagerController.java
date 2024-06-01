package com.ecommerce.springbootbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.springbootbackend.model.Product;
import com.ecommerce.springbootbackend.repo.ProductManagerRepository;

@RestController
@RequestMapping("/productmanager")
public class ProductManagerController {
    @Autowired
    ProductManagerRepository repo;

    // Add Product REST API
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        Product savedResult = repo.save(product);
        return savedResult;
    }

    // Remove Product by ID REST API
    @DeleteMapping("/removeProduct/{id}")
    public Iterable<Product> removeProduct(@PathVariable("id") String productId) {
        repo.deleteById(productId);
        return repo.findAll();
    }

    // Get All Products REST API
    @GetMapping("/getProducts")
    public Iterable<Product> viewAllProducts() {
        return repo.findAll();
    }

    // Update Product Stock Quantity by ID REST API
    @PutMapping("/updateStock/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product productDetails)
            throws Exception {
        Product updateProduct = repo.findById(id)
                .orElseThrow(() -> new Exception("Product not exist with id: " + id));
        updateProduct.setStockQuantity(productDetails.getStockQuantity());
        repo.save(updateProduct);

        return ResponseEntity.ok(updateProduct);
    }
}
