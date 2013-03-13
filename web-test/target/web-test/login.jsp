<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Login do sistema</title>
</head>
<body>
	<center>
		<div style="width: 300px; text-align: center;">
			<h3>Login do sistema</h3>
			<form action="login" method="post">
				E-Mail: <input id="emailInput" type="text" name="email" />
				<br/>
				Senha: <input id="senhaInput" type="password" name="senha" />
				<c:if test="${not empty mensagemErro}">
					<br/>
					<span style="color: red;">${mensagemErro}</span>
				</c:if>
				<hr/>
				<input id="limparBtn" type="reset" name="limparBtn" value="Limpar" />
				<input id="loginBtn" type="submit" name="loginBtn" value="Login" />
			</form>
		</div>
	</center>
</body>
</html>