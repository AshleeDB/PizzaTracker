package com.example.pizzadashboard.dto;

public class OrderRequest {// Declares a simple data transfer object (DTO) class
    private Long menuItemId;
    private int quantity;

    public OrderRequest() {}
    public OrderRequest(Long menuItemId, int quantity) {
        this.menuItemId = menuItemId;
        this.quantity = quantity;
    }

    public Long getMenuItemId() {// Getter for 'menuItemId'
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {// Setter for 'menuItemId'
        this.menuItemId = menuItemId;
    }

    public int getQuantity() {// Getter for 'quantity'
        return quantity;
    }

    public void setQuantity(int quantity) { // Setter for 'quantity'
        this.quantity = quantity;
    }
}
