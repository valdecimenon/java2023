<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Consulta</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

	<div class="table-responsive text-center">
	
	
		<h3 class="mt-3">Lista de Alunos</h3>
		
		<table class="table table-striped table-bordered table-hover align-middle mt-3">
			<thead class="table-primary">
				<tr>
					<td>ID</td>
					<td>Nome</td>
					<td>Cursos</td>
					<td>E-mail</td>
					<td>Data</td>
					<td>Ação</td>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="aluno" items="${alunoBean.todos}">
					<tr>
						<td>${aluno.id}</td>
						<td>${aluno.nome}</td>
						<td>${aluno.curso}</td>
						
						<td>
							<c:if test="${not empty aluno.email}">
								<a href="mailto:${aluno.email}">${aluno.email}</a>
							</c:if>
							<c:if test="${empty aluno.email}">
								E-mail não informado
							</c:if>
						</td>
						
						<td>
							<c:choose>
								<c:when test="${not empty aluno.data}">
									<fmt:parseDate value="${aluno.data}" pattern="yyyy-MM-dd" var="alunoData" type="date"/>
									<fmt:formatDate value="${alunoData}" pattern="dd/MM/yyyy"/>
								</c:when>
							</c:choose>
						</td>
						<td>
							<a href="excluir?id=${aluno.id}" class="btn btn-primary">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
		
		<a href="cadastra.jsp" class="btn btn-primary">Cadastrar</a>
		<a href="excel" class="btn btn-primary">Download .xlsx</a>
	</div>

</body>
</html>