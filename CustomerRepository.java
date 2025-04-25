package com.example.pizzadashboard.repository;
// Imports the Customer model
import com.example.pizzadashboard.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
// Interface to handle DB operations for Customer entity
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Custom query method: Finds a customer by their username (used for signup checks)
    Customer findByUsername(String username); // already added ✅
    // Custom query method: Finds a customer by username and password (used for login)
    Customer findByUsernameAndPassword(String username, String password); // 👈 ADD this line
}
