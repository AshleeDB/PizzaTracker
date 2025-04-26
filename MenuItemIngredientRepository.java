package com.example.pizzadashboard.repository;

import com.example.pizzadashboard.model.MenuItemIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemIngredientRepository extends JpaRepository<MenuItemIngredient, Long> {
}
