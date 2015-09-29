<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de produtos</title>
</head>
<body>
	<div class="container">
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">${mensagem}</div>
		</c:if>

		<h1>Listagem de Produtos</h1>

		<table class="table table-stripped table-hover table-bordered">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Valor</th>
					<th>Quantidade</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtoList}" var="produto">
					<tr>
						<td>${produto.nome}</td>
						<td>${produto.valor}</td>
						<td>${produto.quantidade}</td>
						<td><a
							href="<c:url value='/produto/remove?produto.id=${produto.id}'/>">Remover</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a href="<c:url value='/produto/formulario'/>"> Adicionar mais
			produtos! </a>
	</div>

</body>
</html>