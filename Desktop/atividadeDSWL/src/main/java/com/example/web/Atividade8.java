package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.web.utils.Produto;


@WebServlet("/atividade8")
public class Atividade8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Produto> produtos = new ArrayList<Produto>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		produtos.add(new Produto(request.getParameter("nome"), new BigDecimal(request.getParameter("preco"))));
		
		PrintWriter out = response.getWriter();
		produtos.forEach(p -> {
			out.append("Nome: ")
			.append(p.getNome())
			.append("\tPreço: R$")
			.append(p.getPreco().setScale(2).toString())
			.append("\n");
		});
	}
}
