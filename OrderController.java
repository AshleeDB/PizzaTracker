package com.example.pizzadashboard.controller;
import com.example.pizzadashboard.dto.OrderRequest;


import com.example.pizzadashboard.dto.OrderRequest;
import com.example.pizzadashboard.model.MenuItem;
import com.example.pizzadashboard.model.MenuItemIngredient;
import com.example.pizzadashboard.model.Ingredient;
import com.example.pizzadashboard.repository.MenuItemRepository;
import com.example.pizzadashboard.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private MenuItemRepository menuItemRepo;

    @Autowired
    private IngredientRepository ingredientRepo;

    @PostMapping
    public String placeOrder(@RequestBody List<OrderRequest> orderList) {
        for (OrderRequest request : orderList) {
            MenuItem item = menuItemRepo.findById(request.getMenuItemId()).orElse(null);
            if (item == null) continue;

            for (MenuItemIngredient mii : item.getIngredients()) {
                Ingredient ing = mii.getIngredient();
                int required = mii.getAmountRequired() * request.getQuantity();
                if (ing.getQuantity() < required) {
                    return "❌ Not enough " + ing.getName() + " for " + item.getName();
                }
            }
        }

        // All good: deduct inventory
        for (OrderRequest request : orderList) {
            MenuItem item = menuItemRepo.findById(request.getMenuItemId()).orElse(null);
            if (item == null) continue;

            for (MenuItemIngredient mii : item.getIngredients()) {
                Ingredient ing = mii.getIngredient();
                int used = mii.getAmountRequired() * request.getQuantity();
                ing.setQuantity(ing.getQuantity() - used);
                ingredientRepo.save(ing);
            }
        }

        return "✅ Order placed successfully!";
    }
}
