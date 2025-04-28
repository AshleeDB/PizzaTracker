package com.example.pizzadashboard.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MenuItemIngredient> ingredients;


    // Getters AND Setters for the ID, NAME, PRICE.
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public List<MenuItemIngredient> getIngredients() { return ingredients; }
    public void setIngredients(List<MenuItemIngredient> ingredients) { this.ingredients = ingredients; }
}
