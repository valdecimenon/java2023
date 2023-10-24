package com.softgraf.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.softgraf.beans.AlunoBean;
import com.softgraf.entity.Aluno;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/restapi/*")
public class RestAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoBean alunoBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getPathInfo();
		Integer id = null;
		System.out.println(path);   
		
		if (path != null) {
			String[] arr = path.split("/");
			System.out.println(Arrays.toString(arr));
			if (arr.length > 1) {
				try {
					// http://localhost:8080/CDI_JSP/restapi/3
					id = Integer.parseInt(arr[1]);  // 3
				} catch (Exception ex) {
				};
			}
		}
		
		
		String alunosJson = "null";
		Gson gson = new Gson();
		
		// rota = "/restapi" (null) ou "/restapi/" (/)  => retorna todos os alunos
		if (id == null) {			
			List<Aluno> todos = alunoBean.getTodos();
			if (todos.size() > 0)
				alunosJson = gson.toJson(todos);
			
		// rota = "/restapi/id" => retorna um único aluno se encontrado
		} else {
			Aluno aluno = alunoBean.getPorId(id);
			if (aluno != null)
				alunosJson = gson.toJson(aluno);
		}
		
		
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.getWriter().append(alunosJson);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}


}
