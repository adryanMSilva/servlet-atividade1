package com.example.teste_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teste_spring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
