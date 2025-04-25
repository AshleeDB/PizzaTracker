package com.example.pizzadashboard.controller;
import com.example.pizzadashboard.dto.OrderRequest;


import com.example.pizzadashboard.dto.OrderRequest; // Importing the DTO that contains order details
import com.example.pizzadashboard.model.MenuItem; // Importing the MenuItem model to get menu item details
import com.example.pizzadashboard.model.MenuItemIngredient; // Importing the MenuItemIngredient model for ingredient quantity requirements
import com.example.pizzadashboard.model.Ingredient;  // Importing the Ingredient model to track ingredient quantities
import com.example.pizzadashboard.repository.MenuItemRepository;
import com.example.pizzadashboard.repository.IngredientRepository; // Repository for accessing MenuItem data
import org.springframework.beans.factory.annotation.Autowired; // Repository for accessing Ingredient data
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*") // Allows cross-origin requests from any domain (for development purposes)
public class OrderController { 

    @Autowired
    private MenuItemRepository menuItemRepo; // Injecting the MenuItem repository to access menu items

    @Autowired
    private IngredientRepository ingredientRepo; // Injecting the Ingredient repository to access ingredients

    @PostMapping
    public String placeOrder(@RequestBody List<OrderRequest> orderList) {
         // Loop through each order request in the order list
        for (OrderRequest request : orderList) {
              // Find the MenuItem by its ID
            MenuItem item = menuItemRepo.findById(request.getMenuItemId()).orElse(null); 
            if (item == null) continue; // If the MenuItem does not exist, skip this iteration
            // Check if there is enough inventory for each ingredient in the MenuItem
            for (MenuItemIngredient mii : item.getIngredients()) {
                Ingredient ing = mii.getIngredient();  // Get the ingredient used in the menu item
                int required = mii.getAmountRequired() * request.getQuantity(); // Calculate the required quantity based on the order quantity
                if (ing.getQuantity() < required) { 
                     // If there's not enough of the ingredient, return an error message
                    return "❌ Not enough " + ing.getName() + " for " + item.getName();
                }
            }
        }

       // If all ingredients are available, deduct inventory and place the order
        for (OrderRequest request : orderList) {
            MenuItem item = menuItemRepo.findById(request.getMenuItemId()).orElse(null);
            if (item == null) continue; // If the MenuItem does not exist, skip this iteration
// Loop through each ingredient in the MenuItem and deduct the quantity from inventory
            for (MenuItemIngredient mii : item.getIngredients()) {
                Ingredient ing = mii.getIngredient();
                int used = mii.getAmountRequired() * request.getQuantity(); // Calculate how much of the ingredient is being used
                ing.setQuantity(ing.getQuantity() - used); // Deduct the quantity from the ingredient's stock
                ingredientRepo.save(ing);  // Save the updated ingredient back to the database
            }
        }
         // Return a success message once the order has been placed and the inventory updated

        return "✅ Order placed successfully!";
    }
}
