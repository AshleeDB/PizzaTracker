package com.example.pizzadashboard.repository;

import com.example.pizzadashboard.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
