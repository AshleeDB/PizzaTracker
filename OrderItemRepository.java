// OrderItemRepository.java
package com.example.pizzadashboard.repository;

import com.example.pizzadashboard.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> { }
