package com.example.pizzadashboard.controller;
import org.springframework.http.ResponseEntity;

import com.example.pizzadashboard.model.Customer;
import com.example.pizzadashboard.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
     * Endpoint for signing up new customers
     * URL: POST /customers/signup
     * Accepts a JSON object representing a Customer in the request body
     */
@RestController
public class CustomerController {

    @PostMapping("/customers/signup")
    public ResponseEntity<String> signup(@RequestBody Customer customer) {
         // Check if the username already exists in the database
        if (customerRepo.findByUsername(customer.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists.");
        }
         // Otherwise, save the customer to the database
        customerRepo.save(customer);
        return ResponseEntity.ok("Account created! Please log in.");
         // Return a 200 OK response with a success message
    }

    @Autowired
    private CustomerRepository customerRepo;

    @PostMapping("/customer-login")
    public String login(@RequestParam String username, @RequestParam String password) {
         // Attempt to find a customer by username and password
        Customer customer = customerRepo.findByUsernameAndPassword(username, password);
          // Return success message if found, otherwise return error message
        return customer != null ? "Login successful" : "Invalid credentials";
    }



}
