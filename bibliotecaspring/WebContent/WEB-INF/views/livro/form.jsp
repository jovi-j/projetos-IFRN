<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/header.jsp"%>

<form method="POST" action="/bibliotecaspring/livro" style="width:70%; margin:0 auto;">
<div class="card">
    <div class="card-content login">
        <p class="title">
            Adicionar Livro
        </p>
        <div class="field">
            <label class="label">T�tulo</label>
            <div class="control">
                <input class="input" name="titulo" type="text" placeholder="Eu, Rob�">
            </div>
        </div>
        <div class="field">
            <label class="label">Autor</label>
            <div class="control">
                <input class="input" name="matricula" type="autor" placeholder="Isaac Asimov">
            </div>
        </div>
        <div class="field">
            <label class="label">Editora</label>
            <div class="control">
                <input class="input" name="editora" type="text" placeholder="Abril">
            </div>
        </div>
        <div class="field">
            <label class="label">Ano de Publica��o</label>
            <div class="control">
                <input class="input" name="ano" type="text" placeholder="1990">
            </div>
        </div>
        <div class="field">
            <label class="label">Edi��o</label>
            <div class="control">
                <input class="input" name="edicao" type="text" placeholder="Primeira Edi��o">
            </div>
        </div>
        
        <div class="has-text-centered">
            <button type="submit" class="button is-link">Adicionar Livro</button>
        </div>
    </div>
    
</div>
</form>

</body>
</html>