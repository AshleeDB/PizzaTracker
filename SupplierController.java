package com.example.pizzadashboard.controller;

import com.example.pizzadashboard.model.Supplier;
import com.example.pizzadashboard.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")// Base URL path for all methods in this controller
@CrossOrigin(origins = "*")
public class SupplierController {// Declares the SupplierController class

    @Autowired
    private SupplierRepository supplierRepo;

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();//fetches all suppliers from the database. 
    }
}
