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

import com.example.web.utils.Comentario;


@WebServlet("/atividade6")
public class Atividade6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Comentario> comentarios = new ArrayList<Comentario>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		comentarios.add(new Comentario(request.getParameter("autor"), request.getParameter("comentario")));
		
		PrintWriter out = response.getWriter();
		
		comentarios.forEach(c -> {
			out.append("<h1>")
			.append(c.getAutor())
			.append("</h1><p>")
			.append(c.getTexto())
			.append("</p><hr>");
		});
	}

}
