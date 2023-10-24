package com.softgraf.servlets;

import java.io.IOException;
import java.time.LocalDate;

import com.softgraf.entity.Aluno;
import com.softgraf.repository.AlunoRepository;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/salvar")
public class Salvar extends HttpServlet {

	private static final long serialVersionUID = -6857402053328697167L;
	
	@Inject
	private AlunoRepository repositorioAluno;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Aluno aluno = new Aluno();
		aluno.setNome(req.getParameter("nome"));
		aluno.setCurso(req.getParameter("curso"));
		aluno.setEmail(req.getParameter("email"));
		
		String sData = req.getParameter("data");
		if (sData.isEmpty())
			aluno.setData(null);
		else
			aluno.setData(LocalDate.parse(sData));
		
		System.out.println("\nPersistindo aluno");
		repositorioAluno.adicionar(aluno);
		
		System.out.println("\nRedirecionando");
		resp.sendRedirect(req.getContextPath() + "/index.jsp");
	}
	
	

}
