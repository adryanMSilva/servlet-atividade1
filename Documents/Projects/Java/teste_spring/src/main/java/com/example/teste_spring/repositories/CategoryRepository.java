package com.example.teste_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teste_spring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
