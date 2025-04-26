package com.example.pizzadashboard.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore // Add this line
    private Order order;


    @ManyToOne
    private MenuItem menuItem;

    private int quantity;

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }

    public MenuItem getMenuItem() { return menuItem; }

    public void setMenuItem(MenuItem menuItem) { this.menuItem = menuItem; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
}
