package com.example.pizzadashboard.repository;

import com.example.pizzadashboard.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
// The interface extends JpaRepository, which gives us basic CRUD methods
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
