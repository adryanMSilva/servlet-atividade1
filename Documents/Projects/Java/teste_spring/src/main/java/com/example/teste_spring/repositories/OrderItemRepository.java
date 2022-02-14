package com.example.teste_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teste_spring.entities.OrderItem;
import com.example.teste_spring.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
