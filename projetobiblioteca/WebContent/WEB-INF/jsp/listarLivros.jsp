<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="node_modules/bulma/css/bulma.css">
<link rel="stylesheet" type="text/css" href="css/estilo.css">
 <link rel="stylesheet" type="text/css" href="node_modules/fontawesome-free/css/all.css">
<meta charset="UTF-8">
<title>Lista de Livros</title>
</head>
<body>
	<nav class="breadcrumb" aria-label="breadcrumbs">
		<ul>
			<li><a href="/biblioteca/">Início</a></li>
			<li><a href="mvc?logica=ListaLivroLogic" aria-current="page"
				class="is-active">Listar Livros</a></li>
		</ul>
	</nav>

<div class="box table-box">

<h1 class="title is-3">Livros no Acervo:</h1>

	<table class="table is-bordered is-striped is-narrow is-hoverable">

		<tr>

			<th>Id</th>
			<th>Nome</th>
			<th>Autor</th>
			<th>Seção</th>
			<th>Ano</th>
			<th>Quantidade</th>
			<th>Remoção</th>

		</tr>

		<c:forEach var="l" items="${livros}">

			<tr>

				<td>${l.id}</td>
				<td>${l.nome}</td>
				<td>${l.autor}</td>
				<td>${l.secao}</td>
				<td>${l.ano}</td>
				<td>${l.quantidade}</td>
				<td><a class="button is-danger"
					href="mvc?logica=RemoveLivroLogic&id=${l.id}"> Remover Livro<i class="fa fa-minus-square" style= "padding-left: 0.3em;"></i></a></td>
			</tr>

		</c:forEach>

	</table>
</div>

</body>
</html>