// This package defines the controller layer for the pizza dashboard application
package com.example.pizzadashboard.controller;
// Importing required Spring classes for HTTP response handling
import org.springframework.http.ResponseEntity;
// Importing the Customer model and repository to use in our controller
import com.example.pizzadashboard.model.Customer;
import com.example.pizzadashboard.repository.CustomerRepository;
// Autowiring support
import org.springframework.beans.factory.annotation.Autowired;
// For creating RESTful web services
import org.springframework.web.bind.annotation.*;
// Marks this class as a REST controller where each method returns a domain object instead of a view

@RestController
public class CustomerController {
    // Injects the CustomerRepository so we can interact with the database
    @PostMapping("/customers/signup")
    public ResponseEntity<String> signup(@RequestBody Customer customer) {
                // Check if the username already exists in the database
        if (customerRepo.findByUsername(customer.getUsername()) != null) {
                        // If yes, return a 400 Bad Request with a message
            return ResponseEntity.badRequest().body("Username already exists.");
        }
                // Otherwise, save the customer to the database
        customerRepo.save(customer);
        return ResponseEntity.ok("Account created! Please log in.");
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
