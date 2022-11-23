<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/header.jsp"%>

<form method="POST" action="/bibliotecaspring/aluno" style="width:70%; margin:0 auto;">
<div class="card">
    <div class="card-content login">
        <p class="title">
            Adicionar Aluno
        </p>
        <div class="field">
            <label class="label">Nome</label>
            <div class="control">
                <input class="input" name="nome" type="text" placeholder="Jovi">
            </div>
        </div>
        <div class="field">
            <label class="label">Matrúcula</label>
            <div class="control">
                <input class="input" name="matricula" type="text" placeholder="20141074010169">
            </div>
        </div>
        <div class="field">
            <label class="label">CPF</label>
            <div class="control">
                <input class="input" name="cpf" type="text" placeholder="121.021.123-01">
            </div>
        </div>
        <div class="field">
            <label class="label">Endereço</label>
            <div class="control">
                <input class="input" name="endereco" type="text" placeholder="Rua Fel. Tetel">
            </div>
        </div>
        <div class="field">
            <label class="label">Data de Nascimento</label>
            <div class="control">
                <input class="input" name="dataNascimento" type="text" placeholder="Formato:01/01/1999">
            </div>
        </div>
        
        <div class="has-text-centered">
            <button type="submit" class="button is-link">Adicionar Aluno</button>
        </div>
    </div>
    
</div>
</form>

</body>
</html>