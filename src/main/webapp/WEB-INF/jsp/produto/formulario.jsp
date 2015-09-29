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
	<h1>Adicionar Produto</h1>
		
	<form action="<c:url value='/produto/adiciona'/>" method="post">
        Nome: <input  class="form-control" type="text" name="produto.nome" value="${produto.nome}" />
        Valor: <input class="form-control" type="text" name="produto.valor" value="${produto.valor}" />
        Quantidade: <input class="form-control" type="text" name="produto.quantidade" value="${produto.quantidade}" />
        <button type="submit" class="btn btn-primary" >Adicionar</button>
    </form>
    
    <c:if test="${not empty errors}">
    	<div class="alert alert-danger">
    		<c:forEach items="${errors}" var="error">
				${error.category} - ${error.message}<br/>
			</c:forEach>
    	</div>
    </c:if>    
</div>
	

</body>
</html>