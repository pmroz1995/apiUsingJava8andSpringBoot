package com.eversis.recruitmenttask.dao.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String CustomerName;

    @OneToMany
    private List<Product> products;

    public Customer(){}

    public Customer(Long id, String customerName, List<Product> products) {
        this.id = id;
        CustomerName = customerName;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer id(Long id) {
        this.id = id;
        return this;
    }

    public Customer CustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
        return this;
    }

    public Customer products(List<Product> products) {
        this.products = products;
        return this;
    }
}
