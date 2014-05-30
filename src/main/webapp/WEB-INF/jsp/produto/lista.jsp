<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
 	    <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
        <title>Lista de Produtos</title>
    </head>
    <body>
    	<div class="container">

	        <h1>Listagem de Produtos</h1>
	        <table class="table table-stripped table-hover table-bordered">
	            <thead>
	                <tr>
	                    <th>Nome</th>
	                    <th>Valor</th>
	                    <th>Quantidade</th>
	                </tr>
	              </thead>
	              <tbody>
	              <c:forEach items="${produtoList}" var="produto">
	                <tr>
	                    <td>${produto.nome}</td>
	                    <td>${produto.valor}</td>
	                    <td>${produto.quantidade}</td>
	                </tr>
	            </c:forEach>
	            </tbody>
	        </table>
        </div>
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">${mensagem}</div>
		</c:if>
</body>
</html>