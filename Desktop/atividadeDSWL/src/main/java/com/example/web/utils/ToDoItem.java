package com.example.web.utils;

public class ToDoItem {
	private String titulo;
	private String texto;
	
	public ToDoItem(String titulo, String texto) {
		super();
		this.titulo = titulo;
		this.texto = texto;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public String getTexto() {
		return texto;
	}
}
