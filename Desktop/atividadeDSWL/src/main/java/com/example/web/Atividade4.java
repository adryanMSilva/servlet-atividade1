package com.example.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/atividade4")
public class Atividade4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int contador = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contador++;
		response.getWriter().append("O servlet foi acessado ").append(String.valueOf(contador)).append(" vez(es)");
	}

}
