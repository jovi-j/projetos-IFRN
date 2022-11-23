<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Livros</title>

<link rel="stylesheet" type="text/css"
	href="node_modules/bulma/css/bulma.css">
<link rel="stylesheet" type="text/css" href="css/estilo.css">
 <link rel="stylesheet" type="text/css" href="node_modules/fontawesome-free/css/all.css">

</head>
<body>
	<nav class="breadcrumb" aria-label="breadcrumbs">
		<ul>
			<li><a href="/biblioteca/">Início</a></li>
			<li><a href="/biblioteca/formLivro.jsp" aria-current="page"
				class="is-active">Adicionar Livro</a></li>
		</ul>
	</nav>
	<form action="mvc?" class="box is-info">
		<h1 class="title is-3">Adicionar Livro</h1>
		<input type="hidden" name="logica" value="AdicionaLivroLogic">
		<div>
			<label class="label">Nome: </label> <input type="text"
				placeholder="Eu, Robô" name="nome" class="input is-half">
		</div>
		<div>
			<label class="label">Autor: </label> <input type="text" name="autor"
				placeholder="Isaac Asimov" class="input is-half">
		</div>
		<div>
			<label class="label">Seção: </label> <input type="text" name="secao"
				placeholder="Ficção Científica" class="input is-half">
		</div>
		<div>
			<label class="label">Ano: </label> <input type="text" name="ano"
				placeholder="1950" class="input is-half">
		</div>
		<div>
			<label class="label">Quantidade: </label> <input type="text"
				name="quantidade" placeholder="10" class="input is-half">
		</div>


		<div>
			<button type="submit" class="button is-primary"> <i class="fas fa-plus" style= "padding-right: 0.2em;"></i>Adicionar</button>
		</div>
	</form>
</body>
</html>
