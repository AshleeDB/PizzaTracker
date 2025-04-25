package com.example.pizzadashboard.model;

import jakarta.persistence.*;
// Marks this class as a JPA entity — it maps to a database table called 'Customer'
@Entity
public class Customer {
    // Primary key for the Customer table, auto-generated (usually auto-incremented)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
    private Long id;
     // Username for the customer (used for login/authentication)
    private String username;
    // Password for the customer
    private String password;
// === Getters and Setters ===
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

