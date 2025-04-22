package com.example.pizzadashboard.controller;
import org.springframework.http.ResponseEntity;

import com.example.pizzadashboard.model.Customer;
import com.example.pizzadashboard.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @PostMapping("/customers/signup")
    public ResponseEntity<String> signup(@RequestBody Customer customer) {
        if (customerRepo.findByUsername(customer.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists.");
        }
        customerRepo.save(customer);
        return ResponseEntity.ok("Account created! Please log in.");
    }

    @Autowired
    private CustomerRepository customerRepo;

    @PostMapping("/customer-login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Customer customer = customerRepo.findByUsernameAndPassword(username, password);
        return customer != null ? "Login successful" : "Invalid credentials";
    }



}
