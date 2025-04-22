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

    @Autowired
    private MenuItemRepository menuItemRepo;

    @GetMapping
    public List<MenuItem> getAvailableMenuItems() {
        return menuItemRepo.findAll().stream()
                .filter(item -> item.getIngredients().stream()
                        .allMatch(mii -> mii.getIngredient().getQuantity() >= mii.getAmountRequired()))
                .toList();
    }





}
