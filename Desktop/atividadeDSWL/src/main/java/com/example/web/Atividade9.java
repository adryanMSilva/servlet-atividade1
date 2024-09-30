package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/atividade9/removeNome")
public class Atividade9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static List<String> nomes = new ArrayList<String>(Arrays.asList(
            "Ana", "Carlos", "Maria", "João", "Lucas", 
            "Fernanda", "Pedro", "Beatriz", "Gabriel", "Julia"
        ));

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");

		if(nomes.removeIf(nome -> nome.equalsIgnoreCase(request.getParameter("nome")))) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Usuário não encontrado!');");
			out.println("</script>");
		}
		
		out.println("<ul>");
		nomes.forEach(n -> out.println("<li>" + n + "</li>"));
		out.println("</ul>");
	}

}
