<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>WEB-TEST: Listagem de Usuarios</title>
</head>
<body>
	<h3>WEB-TEST: Listagem de Usuarios</h3>
	<hr/>
	<c:if test="${empty usuarios}">
		Usuarios nao cadastrados
	</c:if>
	<c:if test="${not empty usuarios}">
		<table border="1" cellspacing="0" cellpadding="2" width="100%">
			<thead>
				<tr>
					<th>Usuario</th>
					<th>E-Mail</th>
					<th>Senha</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${usuarios}">
					<tr>
						<td>${usuario.nome}</td>
						<td>${usuario.email}</td>
						<td>${usuario.senha}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<hr/>
	<a id="voltarLink" href="<c:url value="/index.jsp" />">Voltar</a>	
</body>
</html>
