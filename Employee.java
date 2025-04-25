package com.example.pizzadashboard.model;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     // Field for storing the employee's username
    private String username;
    // Field for storing the employee's password
    private String password;
    // Default no-argument constructor (required by JPA)
    public Employee() {}
     // Constructor to create a new Employee object with username and password
    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }
// Getters and setters for the id, username and password 
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
