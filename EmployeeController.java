// Package location of the controller (organizes code structure)
package com.example.pizzadashboard.controller;
// Import the Employee model and the EmployeeRepository interface
import com.example.pizzadashboard.model.Employee;
import com.example.pizzadashboard.repository.EmployeeRepository;
// Spring Framework annotations for dependency injection and web APIs
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class EmployeeController {
     /**
     * Handles POST requests to /login
     * Accepts username and password as URL parameters (e.g., ?username=abc&password=123)
     */

    @Autowired
    private EmployeeRepository employeeRepo;

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password) {
          // Tries to fetch an Employee by their username
        Employee emp = employeeRepo.findByUsername(username);
        // Checks if employee exists and if password matches
        if (emp != null && emp.getPassword().equals(password)) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }
}
