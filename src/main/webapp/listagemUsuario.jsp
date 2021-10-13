<%@page import="br.com.sprint2.model.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de usuarios</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div id="menu">
		<nav class="navbar navbar-expand-lg navbar-light bg-light mb-4">
			<div class="container-fluid">
				<a class="navbar-brand" th:href="@{/}">Controle CsLibras</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">

						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/Sprint2">Home</a></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Usuarios </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="/Sprint2/cadastro">Cadastrar
										novo usuario</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item"
									href="/Sprint2/listagemUsuario">Todos os usuarios</a></li>
							</ul></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Catalogo </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="">Cadastrar
										categoria no catalogo</a></li>
								<li><a class="dropdown-item" href="">Listar itens do
										catalogo</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="/mesa">Listar itens
										catalogo</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Usuario</th>
					<th>Senha</th>
				</tr>
			</thead>
			<%
			List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");
			for (Usuario usuario : lista) {
			%>
			<tr>
				<td><%=usuario.getId()%></td>
				<td><%=usuario.getNome()%></td>
				<td><%=usuario.getSenha()%></td>
				<td><a type="button" class="btn btn-warning"
					href="/Sprint2/mostraUsuario?id=<%=usuario.getId()%>">EDITAR</a></td>
				<td><a type="button" class="btn btn-danger" onclick="return confirm('Voc� deseja realmente excluir esse usuario?')"
					href="/Sprint2/removerUsuario?id=<%=usuario.getId()%>">EXCLUIR</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>