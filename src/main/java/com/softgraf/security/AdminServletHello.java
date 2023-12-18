package com.softgraf.security;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/hello")
public class AdminServletHello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SecurityContext securityContext;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		out.print("<h3>Hello Administrador</h3>");
		out.print("<h4>Nome: " + securityContext.getCallerPrincipal().getName() + "</h4>");
		out.print("</body></html>");
	}

}
