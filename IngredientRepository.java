package com.example.pizzadashboard.repository;

import com.example.pizzadashboard.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
// This interface connects the Ingredient entity to the database
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
   // No need to write anything extra unless we want custom queries
    // JpaRepository provides all the CRUD methods out of the box
}
