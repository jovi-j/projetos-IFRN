<%@page import="agenda.models.Contato"%>
<%@page import="java.util.List"%>
<%@page import="agenda.daos.ContatoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="estilos/estilo1.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Contatos</title>
</head>
<body>
	<c:import url="/assets/cabecalho.jsp" />


	<table>

		<c:forEach var="c" items="${contatos}">

			<tr>

				<td>${c.id}</td>
				<td>${c.nome}</td>
				<td>${c.email}</td>
				<td>${c.endereco}</td>
				<td>${c.dataNascimento.time}</td>
				<td><a class="del" href="mvc?logica=RemoveContatoLogic&id=${c.id}">Deletar
						Contato</a></td>
			</tr>

		</c:forEach>

	</table>



</body>
</html>
