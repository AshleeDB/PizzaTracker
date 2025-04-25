// Defines this class as part of the 'model' package (holds your data layer)
package com.example.pizzadashboard.model;
// JPA annotations for mapping this class to a database table
import jakarta.persistence.*;
// Java's date class for handling restock dates
import java.time.LocalDate;
// Marks this class as a database entity (i.e., it represents a table)
@Entity
public class Ingredient {
    // Primary key for the Ingredient table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Name of the ingredient (e.g., Cheese, Pepperoni, Sauce)
    private String name;
    // Current quantity of the ingredient in stock
    private int quantity;
    // The expected date of the next restock
    private LocalDate nextRestockDate;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public LocalDate getNextRestockDate() { return nextRestockDate; }
    public void setNextRestockDate(LocalDate nextRestockDate) { this.nextRestockDate = nextRestockDate; }
}
