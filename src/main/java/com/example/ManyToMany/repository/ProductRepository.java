package com.example.ManyToMany.repository;

import com.example.ManyToMany.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
