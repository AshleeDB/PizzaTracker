package com.example.pizzadashboard.controller;

import com.example.pizzadashboard.model.Employee;
import com.example.pizzadashboard.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController// handling http requests
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired // Tells Spring to automatically inject an instance of EmployeeRepository
    private EmployeeRepository employeeRepo;

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password) {//
        Employee emp = employeeRepo.findByUsername(username);
        if (emp != null && emp.getPassword().equals(password)) {//// Check if employee exists and password matches
            return "Login successful"; // If valid, return success message
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }
}
