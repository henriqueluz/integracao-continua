<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>WEB-TEST: Pagina Inicial</title>
</head>
<body>
	<h3>WEB-TEST: Pagina Inicial</h3>
	<hr/>
	<a id="usuarioLink" href="<c:url value="/usuario.srv" />">Listagem de Usuarios</a>
	<hr/>
	<a id="sairLink" href="<c:url value="/logout" />">Sair</a>	
</body>
</html>