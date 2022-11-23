<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/resources/header.jsp"%>
<style> .frm > *{ margin: 0 3em; } </style>

<div class="hero is-vcentered" style="width: 70%; margin: 0 auto">

	<h1 class="title is-vcentered">Lista de Livros</h1>

	<form method="POST" class="frm" action="/bibliotecaspring/livro/buscar" style="display:flex;">
				<div class="container" style="display:flex;">
				<input class="input" placeholder="Buscar por Título" style="margin-right: 1em;" name="titulo"></input>
				<button type="submit" class="button is-info">Buscar</button>
				</div>
				<a href="/bibliotecaspring/livro/form"
					class="button is-one-third is-info"
					style="margin-bottom: 0.5rem; width: 20%">Adicionar Novo Livro</a>
		
	</form>

	<table class="table" border="2">
		<thead>
			<tr>
				<th>Título</th>
				<th>Autor</th>
				<th>Editora</th>
				<th>Ano de Publicação</th>
				<th>Edição</th>
				<th>Fazer Emprestimo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="livro" items="${livros }">
				<tr>
					<td>${livro.titulo }</td>
					<td>${livro.autor }</td>
					<td>${livro.editora }</td>
					<td>${livro.ano }</td>
					<td>${livro.edicao }</td>
					<td class="is-one-third">
						<form method="POST" action="/bibliotecaspring/emprestimo" style="display:flex;">
							<input type="hidden" name="idLivro" value="${livro.id}" /> <input
								class="input" type="text" name="matriculaAluno"
								placeholder="Matrícula do Aluno" />
							<button type="submit" style="margin-left: 1em;" class="button is-info">Fazer
								Emprestimo</button>
						</form>
					</td>

				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>



</body>
</html>
