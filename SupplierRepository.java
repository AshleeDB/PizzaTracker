package com.example.pizzadashboard.repository;

import com.example.pizzadashboard.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
