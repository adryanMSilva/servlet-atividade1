package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/atividade7")
public class Atividade7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String, Integer> usuarios = new HashMap<String, Integer>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuarioAcessado = request.getParameter("nome");
		
		if(usuarios.containsKey(usuarioAcessado)) {
			int quantidade = usuarios.get(usuarioAcessado);
			quantidade++;
			usuarios.replace(usuarioAcessado, quantidade);
		} else {
			usuarios.put(usuarioAcessado, 1);
		}
		
		PrintWriter out = response.getWriter();
		
		usuarios.forEach((k,v) -> {
			out.append(k)
			.append(" acessou ")
			.append(v.toString())
			.append(" vez(es)\n");
		});
	}

}
