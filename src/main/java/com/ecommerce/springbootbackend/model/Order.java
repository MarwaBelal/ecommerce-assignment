package com.ecommerce.springbootbackend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customer")
    private String customer;

    @Column(name = "total_amount")
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "fk_order_manager_id", nullable = false)
    private OrderManager orderManager;

    @OneToMany()
    @JoinColumn(name = "fk_order_id")
    private List<Product> products;

    public double calculateTotalAmount(List<Product> productList) {
        double totalAmount = 0;
        for (Product product : productList) {
            totalAmount += product.getPrice();
        }
        return totalAmount;
    }

    // @Override
    // public String toString() {
    // return "Order{" + "id=" + id + ", customer='" + customer + '\'' + ",
    // productList='" + productList + '\'' +
    // ", totalAmount='" + totalAmount + '\'' + '}';
    // }

}
