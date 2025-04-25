package com.example.pizzadashboard.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MenuItemIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Primary key with auto-increment strategy
    private Long id;
// Many MenuItemIngredient entries can point to one MenuItem (MenuItem is the parent)
    @ManyToOne
    @JoinColumn(name = "menu_item_id") // This is the foreign key column in the table
    @JsonIgnore // Prevents infinite recursion when serializing to JSON (MenuItem -> MenuItemIngredient -> MenuItem)
    private MenuItem menuItem;
 // Many MenuItemIngredient entries can point to one Ingredient (Ingredient is the parent)
    @ManyToOne
    @JoinColumn(name = "ingredient_id") // This is the foreign key column in the table
    private Ingredient ingredient;
  // The amount of this ingredient required for the menu item

    private int amountRequired;
   // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public MenuItem getMenuItem() { return menuItem; }
    public void setMenuItem(MenuItem menuItem) { this.menuItem = menuItem; }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) { this.ingredient = ingredient; }

    public int getAmountRequired() { return amountRequired; }
    public void setAmountRequired(int amountRequired) { this.amountRequired = amountRequired; }
}
