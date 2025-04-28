package com.example.pizzadashboard.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;
    private LocalDate nextRestockDate;

    // Getter and setters for the ID, NAME, QUANTITY, AND GETNEXTRESTOCKDATE
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public LocalDate getNextRestockDate() { return nextRestockDate; }
    public void setNextRestockDate(LocalDate nextRestockDate) { this.nextRestockDate = nextRestockDate; }
}
