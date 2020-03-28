package com.example.codeengine.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.codeengine.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByName(String name);
}
