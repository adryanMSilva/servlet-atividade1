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

import com.example.web.utils.ToDoItem;

@WebServlet("/atividade10")
public class Atividade10 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static List<ToDoItem> itens = new ArrayList<ToDoItem>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		itens.add(new ToDoItem(request.getParameter("titulo"), request.getParameter("texto")));

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("""
				<style>
				* {
				box-sizing:border-box;
				}

				body {
				background:#444; 
				}

				.post-it {
				width:250px;
				height:240px;
				position:relative;
				background:#ffa;
				overflow:hidden;
				margin:30px auto;
				padding:20px;
				border-radius:0 0 0 30px/45px;
				box-shadow:
				inset 0 -40px 40px rgba(0,0,0,0.2),
				inset 0 25px 10px rgba(0,0,0,0.2),
				0 5px 6px 5px rgba(0,0,0,0.2);
				line-height:1.7em;
				font-size:19px;
				-webkit-mask-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAA5JREFUeNpiYGBgAAgwAAAEAAGbA+oJAAAAAElFTkSuQmCC);

				color:#130d6b;
				}

				.post-it li {
				cursor:pointer; 
				}

				.post-it:before {
				content:"";
				display:block;
				position:absolute;
				width:20px;
				height:25px;
				background:#ffa;
				box-shadow:
				3px -2px 10px rgba(0,0,0,0.2),
				inset 15px -15px 15px rgba(0,0,0,0.3);
				left:0;
				bottom:0;
				z-index:2;
				transform:skewX(25deg);
				}

				.post-it:after {
				content:"";
				display:block;
				position:absolute;
				width:75%;
				height:20px; 
				border-top:3px solid #130d6b;
				border-radius: 50% ;
				bottom:0px;
				left:10%;
				}

				.done {
				text-decoration:line-through; 
				}

				h1 {
				font-size:25px; 
				position:relative;
				}

				</style>

				""");

		itens.forEach(i -> {
			out.println("<div class='post-it' contenteditable>");
			out.println("<h1>" + i.getTitulo() + "</h1>");
			out.println("<ul><li>" + i.getTexto() + "</li></ul></div>");
		});


	}

}
