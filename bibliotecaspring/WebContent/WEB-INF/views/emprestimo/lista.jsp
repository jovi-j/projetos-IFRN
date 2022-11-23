<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/resources/header.jsp"%>


<div class="hero is-vcentered" style="width:70%; margin: 0 auto">

	<h1 class="title">Lista de Emprestimos</h1>
	<h2 class="subtitle">Clique nos botões abaixo para filtrar os emprestimos:</h2>
<div class="container">
	<a href="/bibliotecaspring/emprestimo/" class="button is-one-third is-info" style="margin-bottom: 0.5rem; width: 20%">Todos os Emprestimos</a>	
	<a href="/bibliotecaspring/emprestimo/ativos" class="button is-one-third is-success" style="margin-bottom: 0.5rem; width: 20%">Emprestimos Ativos</a>
	<a href="/bibliotecaspring/emprestimo/atrasados" class="button is-one-third is-danger" style="margin-bottom: 0.5rem; width: 20%">Emprestimos Atrasados</a>
	
</div>
		<table class="table" border="2">
			<thead>
				<tr>
					<th>Aluno</th>
					<th>Matrícula do Aluno</th>
					<th>Livro</th>
					<th>Data de Emprestimo</th>
					<th>Data de Devolução</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="emprestimo" items="${emprestimos }">
					<tr>
						<td>${emprestimo.aluno.nome }</td>
						<td>${emprestimo.aluno.matricula }</td>
						<td>${emprestimo.livro.titulo }</td>
						<td>${emprestimo.dataEmprestimo.time }</td>
						<c:if test="${empty emprestimo.dataDevolucao}">
							<td class="is-one-third">
								<form method="POST" action="/bibliotecaspring/emprestimo/devolucao"> 
									<input type="hidden" name="idAluno" value="${emprestimo.aluno.id}"/>
									<input type="hidden" name="idLivro" value="${emprestimo.livro.id}"/>
									<button type="submit" class="button is-info">Fazer Devolução</button>  
								</form>
							</td>
						</c:if>
						<c:if test="${not empty emprestimo.dataDevolucao}">
							<td><fmt:formatDate value="${emprestimo.dataDevolucao.time}" pattern="dd/MM/yyyy" /></td>
						</c:if>

					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>


</body>
</html>
