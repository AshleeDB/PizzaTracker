package com.example.pizzadashboard.repository;

import com.example.pizzadashboard.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
