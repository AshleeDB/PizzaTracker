package com.example.pizzadashboard.controller;
// Importing the Ingredient model and its corresponding repository for DB access
import com.example.pizzadashboard.model.Ingredient;
import com.example.pizzadashboard.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
// Java utility for working with lists (used to return multiple ingredients)
import java.util.List;
// This annotation marks this class as a REST controller (it returns data, not views)
// Base URL path for all methods in this controller (e.g., /ingredients)
// Allows this controller to accept requests from any origin (helps with frontend-backend communication
@RestController
@RequestMapping("/ingredients")
@CrossOrigin(origins = "*")
public class IngredientController {
 // Injecting the IngredientRepository to interact with the database
    @Autowired
    private IngredientRepository ingredientRepo;
/**
     * Endpoint to get a list of all ingredients
     * GET /ingredients
     * Returns a list of Ingredient objects (in JSON)
     */
    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientRepo.findAll();
    }
/**
     * Endpoint to add stock to an existing ingredient
     * PUT /ingredients/{id}/add?amount=10
     * Finds the ingredient by ID and increases its quantity by the specified amount
     */
    @PutMapping("/{id}/add")
    public String addInventory(@PathVariable Long id, @RequestParam int amount) {
        // Looks for the ingredient in the database by ID
        Ingredient ingredient = ingredientRepo.findById(id).orElse(null);
        if (ingredient != null) {
            // If found, increase the quantity
            ingredient.setQuantity(ingredient.getQuantity() + amount);
            ingredientRepo.save(ingredient); // Save the updated ingredient back to the DB
            return "Inventory updated!";
        }
         // If ingredient not found, return an error message
        return "Ingredient not found.";
    }
}
