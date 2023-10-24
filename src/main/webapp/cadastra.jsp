<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastra</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

</head>
<body>

	<div class="container col-3">
	
		<h3 class="mt-3">Cadastra Aluno</h3>
		
		<form action="salvar" method="post">
		
			<div class="form-group mt-3">
				<label>Nome:</label>
				<input type="text" name="nome" class="form-control" required/>
			</div>
			
			<div class="form-group mt-3">
				<label>Curso:</label>
				<select name="curso" class="form-select">
					<option value="java" selected>java</option>
					<option value="javascript">Javascript</option>
					<option value="python">Python</option>
				</select>
			</div>
			
			<div class="form-group mt-3">
				<label>Email:</label>
				<input type="email" name="email" class="form-control">
			</div>

			<div class="form-group mt-3">
				<label>Data:</label>
				<input type="date" name="data" class="form-control" value="<%= LocalDate.now() %>"/>	
			</div>
		
			<button type="submit" class="btn btn-primary mt-3">Salvar</button>
			<a href="index.jsp" class="btn btn-secondary mt-3">Consultar</a>
		
		</form>
	
	</div>

</body>
</html>