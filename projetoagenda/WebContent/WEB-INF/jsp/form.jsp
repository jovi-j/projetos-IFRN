<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="estilos/estilo1.css">


<title>Adicionar Contato</title>
</head>
<body>
	<c:import url="/assets/cabecalho.jsp" />
	<h1>Adicionar contato</h1>
	<form action="adicionarContato">
		<div>
			<label>Nome: </label> <input type="text" name="nome">
		</div>
		<div>
			<label>Email: </label> <input type="text" name="email">
		</div>
		<div>
			<label>Endereço: </label> <input type="text" name="endereco">
		</div>
		<div>
			<label>Data de Nascimento: </label>
			<tag:datePicker id="dataNascimento" />
		</div>
		<div>
			<button type="submit">Adicionar</button>
		</div>
	</form>
</body>
</html>
