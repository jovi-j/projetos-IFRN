<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/resources/header.jsp"%>

<div class="card">
    <div class="card-content login">
        <p class="title">
            Erro
        </p>
        <div class="field">
            <label class="label">${erro} </label>
			<div class="has-text-centered">
            <a href="/bibliotecaspring/livro" class="button is-link">Voltar para a página de Livros</a>
        </div>            
        </div>

    </div>
</div>

</body>
</html>
