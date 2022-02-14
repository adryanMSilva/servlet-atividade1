package com.example.teste_spring.services.exceptions;

public class DatabaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DatabaseException(String messsage) {
		super(messsage);
	}

}
