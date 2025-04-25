package com.example.pizzadashboard.controller;

import com.example.pizzadashboard.model.MenuItem;
import com.example.pizzadashboard.model.MenuItemIngredient;
import com.example.pizzadashboard.model.Ingredient;
import com.example.pizzadashboard.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "*")
public class MenuItemController {
// Automatically injects the MenuItemRepository bean
    @Autowired
    private MenuItemRepository menuItemRepo;
  // GET endpoint at '/menu' — returns a list of menu items that can actually be prepared
    @GetMapping
    public List<MenuItem> getAvailableMenuItems() {
          // For each menu item, check that ALL its required ingredients are in stock
        return menuItemRepo.findAll().stream()
                .filter(item -> item.getIngredients().stream()
                        .allMatch(mii -> mii.getIngredient().getQuantity() >= mii.getAmountRequired()))
                .toList(); // Only return menu items that passed the check
    }
}
