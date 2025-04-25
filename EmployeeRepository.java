package com.example.pizzadashboard.repository;

import com.example.pizzadashboard.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
// This interface tells Spring to generate all the database interaction code for Employee
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom query method: Find an Employee by their username (used in login logic)
    Employee findByUsername(String username);
}
