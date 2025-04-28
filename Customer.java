package com.example.pizzadashboard.model;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {// sets the setters and getters for the username
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {// sets the setters and getters for the password 
        return password;
    }

    public void setPassword(String password) {// sets password
        this.password = password;
    }
}

