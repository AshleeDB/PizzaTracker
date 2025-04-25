package com.example.pizzadashboard.repository;

import com.example.pizzadashboard.model.MenuItemIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
// The interface extends JpaRepository, which provides basic methods for database operations
public interface MenuItemIngredientRepository extends JpaRepository<MenuItemIngredient, Long> {
    // You don't need to write anything here for basic CRUD operations,
    // List<MenuItemIngredient> findByMenuItemId(Long menuItemId);
}
