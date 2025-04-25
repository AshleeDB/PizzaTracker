package com.example.pizzadashboard.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class MenuItem {
      // Primary key with auto-increment strategy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 // Name of the menu item (e.g., "Pepperoni Pizza")
    private String name;
     // Price of the menu item
    private double price;
      // One MenuItem has many MenuItemIngredient entries
    // 'mappedBy' points to the 'menuItem' field in the MenuItemIngredient class
    // Cascade.ALL means changes to a MenuItem cascade to its ingredients
    // FetchType.EAGER means ingredients will load immediately with the menu item
    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MenuItemIngredient> ingredients;


    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public List<MenuItemIngredient> getIngredients() { return ingredients; }
    public void setIngredients(List<MenuItemIngredient> ingredients) { this.ingredients = ingredients; }
}
