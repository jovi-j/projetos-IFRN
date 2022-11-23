<%@page import="agenda.models.Contato"%>
<%@page import="java.util.List"%>
<%@page import="agenda.daos.ContatoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getLista();
	%>


	<h1>Meu primeiro JSP! Que coisa mais linda!</h1>
	<% for(Contato contato : contatos) { 
	%>
		<%=contato.getNome() %>
		
	
	<% } %>
	
</body>
</html>




