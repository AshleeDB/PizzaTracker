package com.example.pizzadashboard.controller;

import com.example.pizzadashboard.model.*;
import com.example.pizzadashboard.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private MenuItemRepository menuItemRepo;

    @Autowired
    private IngredientRepository ingredientRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;  // Missing before!

    @PostMapping("/order")
    public ResponseEntity<String> placeOrder(@RequestBody List<OrderItemRequest> items) {
        try {
            Order order = new Order();
            order.setConfirmationCode(generateConfirmationCode());
            orderRepo.save(order);

            for (OrderItemRequest itemRequest : items) {
                MenuItem menuItem = menuItemRepo.findById(itemRequest.getMenuItemId()).orElse(null);
                if (menuItem == null) continue;

                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(order);
                orderItem.setMenuItem(menuItem);
                orderItem.setQuantity(itemRequest.getQuantity());
                orderItemRepo.save(orderItem);

                // 🧹 Decrease inventory here
                for (MenuItemIngredient mii : menuItem.getIngredients()) {
                    Ingredient ingredient = mii.getIngredient();
                    int totalAmountNeeded = mii.getAmountRequired() * itemRequest.getQuantity();
                    ingredient.setQuantity(ingredient.getQuantity() - totalAmountNeeded);
                    ingredientRepo.save(ingredient);
                }
            }

            return ResponseEntity.ok("✅ Order placed! Confirmation #" + order.getConfirmationCode());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("❌ Order failed: " + e.getMessage());
        }
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderRepo.findAll();
    }

    private String generateConfirmationCode() {
        Random random = new Random();
        int number = 10000 + random.nextInt(90000);
        return "ORD-" + number;
    }
}
