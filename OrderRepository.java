// OrderRepository.java
package com.example.pizzadashboard.repository;

import com.example.pizzadashboard.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
