package com.example.pizzadashboard.repository;

import com.example.pizzadashboard.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username); // already added ✅
    Customer findByUsernameAndPassword(String username, String password); // 👈 ADD this line
}
