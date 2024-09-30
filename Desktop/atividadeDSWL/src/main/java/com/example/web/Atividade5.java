package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/atividade5/addNome")
public class Atividade5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<String> nomes = new ArrayList<String>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		nomes.add(request.getParameter("nome"));
		
		PrintWriter out = response.getWriter();
		
		nomes.forEach(out::println);
	}

}
