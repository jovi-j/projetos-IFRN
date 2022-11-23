<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/resources/header.jsp"%>


<div class="hero is-vcentered" style="width:70%; margin: 0 auto">

	<h1 class="title">Lista de Alunos</h1>
	<a href="/bibliotecaspring/aluno/form" class="button is-one-third is-info" style="margin-bottom: 0.5rem; width: 20%">Adicionar Novo Aluno</a>	
		<table class="table" border="2">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Matrícula</th>
					<th>CPF</th>
					<th>Endereço</th>
					<th>Data de Nascimento</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="aluno" items="${alunos }">
					<tr>
						<td>${aluno.nome }</td>
						<td>${aluno.matricula }</td>
						<td>${aluno.cpf }</td>
						<td>${aluno.endereco }</td>	
						<td><fmt:formatDate value="${aluno.dataNascimento.time }" pattern="dd/MM/yyyy" /></td>
				

					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

</div>


</body>
</html>
