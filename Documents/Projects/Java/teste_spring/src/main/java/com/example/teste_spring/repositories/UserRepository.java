package com.example.teste_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teste_spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
