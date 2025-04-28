package com.example.pizzadashboard.controller;

import com.example.pizzadashboard.model.Ingredient;
import com.example.pizzadashboard.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@CrossOrigin(origins = "*")// Allows Cross-Origin requests from any domain
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepo;

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientRepo.findAll();
    }

    @PutMapping("/{id}/add")
    public String addInventory(@PathVariable Long id, @RequestParam int amount) {// adds a quantity to an ingredient by ID
        Ingredient ingredient = ingredientRepo.findById(id).orElse(null);
        if (ingredient != null) {
            ingredient.setQuantity(ingredient.getQuantity() + amount);// increases quantity by specific amount 
            ingredientRepo.save(ingredient);// saves inventory update to the data base 
            return "Inventory updated!";
        }
        return "Ingredient not found.";
    }
}
