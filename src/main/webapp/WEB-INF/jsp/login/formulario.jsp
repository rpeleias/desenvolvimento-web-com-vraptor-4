<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulário de login</title>
</head>
<body>
	<div class="container">
		<form action="<c:url value='/login/autentica'/>" class="form-signin" method="post">
			<h2 class="form-signin-heading">Faça login para acessar o VRaptor-Produtos</h2>
			<input type="text" class="form-control" name="usuario.nome" placeholder="Nome">
			<input type="password" class="form-control" name="usuario.senha" placeholder="Senha">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
		</form>
		
		<c:if test="${not empty errors}">
			<div class="alert alert-danger">
				<c:forEach items="${errors}" var="error">
					${error.category} - ${error.message}<br />
				</c:forEach>
			</div>
		</c:if>
	</div>
</body>
</html>