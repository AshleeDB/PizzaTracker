package com.example.pizzadashboard.controller;

import com.example.pizzadashboard.model.MenuItem;
import com.example.pizzadashboard.model.MenuItemIngredient;
import com.example.pizzadashboard.model.Ingredient;
import com.example.pizzadashboard.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;// Imports Stream API for filtering

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "*")
public class MenuItemController {

    @Autowired
    private MenuItemRepository menuItemRepo;

    @GetMapping
    public List<MenuItem> getAvailableMenuItems() { // Get all menu items from the database and start a stream
        return menuItemRepo.findAll().stream()
                .filter(item -> item.getIngredients().stream() //look at its ingredients for each menu item
                        .allMatch(mii -> mii.getIngredient().getQuantity() >= mii.getAmountRequired()))// only keep menu items with ingredients in stock
                .toList();
    }





}
