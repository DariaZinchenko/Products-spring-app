package com.example.ManyToMany.repository;

import com.example.ManyToMany.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
