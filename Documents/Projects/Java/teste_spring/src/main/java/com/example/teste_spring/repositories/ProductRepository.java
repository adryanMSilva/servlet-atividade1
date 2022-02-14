package com.example.teste_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teste_spring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
