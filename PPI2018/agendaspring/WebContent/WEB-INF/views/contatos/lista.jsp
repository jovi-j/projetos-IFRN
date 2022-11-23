<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Lista de contatos:</h1>

	<table border="2">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Endere�o</th>
				<th>Data de Nascimento</th>
				<th>Apagar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="contato" items="${contatos }">

				<tr>

					<td>${contato.nome }</td>
					<td>${contato.email }</td>
					<td>${contato.endereco }</td>
					<td>${contato.dataNascimento.time }</td>
					<td>
						<form class="btn-apagar" action="/agendaspring/contatos/delete"
							method="post">
							<input type="hidden" name="id" value="${contato.id}" />
							<button type="submit"></button>
						</form>
					</td>

				</tr>
			</c:forEach>

		</tbody>

	</table>


</body>
</html>
