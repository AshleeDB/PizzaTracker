package com.example.pizzadashboard.controller;

import com.example.pizzadashboard.model.Ingredient;
import com.example.pizzadashboard.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@CrossOrigin(origins = "*")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepo;

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientRepo.findAll();
    }

    @PutMapping("/{id}/add")
    public String addInventory(@PathVariable Long id, @RequestParam int amount) {
        Ingredient ingredient = ingredientRepo.findById(id).orElse(null);
        if (ingredient != null) {
            ingredient.setQuantity(ingredient.getQuantity() + amount);
            ingredientRepo.save(ingredient);
            return "Inventory updated!";
        }
        return "Ingredient not found.";
    }
}
