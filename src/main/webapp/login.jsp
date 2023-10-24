<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

	<div class="container col-3">
	
		<h3 class="mt-3">Login</h3>
		
		<form action="index.jsp" method="post">
			
			<div class="form-group mt-3">
				<label>Nome</label>
				<input type="text" name="nome" class="form-control"/>
			</div>
		
			<div class="form-group mt-3">
				<label>Senha</label>
				<input type="password" name="senha" class="form-control"/>
			</div>
			
			<button type="submit" class="btn btn-primary mt-4">Login</button>
			
		</form>
	
	</div>

</body>
</html>