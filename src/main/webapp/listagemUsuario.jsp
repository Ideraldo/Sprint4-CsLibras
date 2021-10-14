<%@page import="br.com.sprint2.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
							aria-current="page" href="/Sprint4">Home</a></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Usuarios </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="/Sprint4/cadastro">Cadastrar
										novo usuario</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item"
									href="/Sprint4/listagemUsuario">Todos os usuarios</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	
	<div class="card">
		<div class="card-header">Filtrar usuarios</div>
		<div class="card-body">
			<blockquote class="blockquote mb-0 container text-center">
				<h1>Preencha os campos que deseja usar como filtro</h1>
				<form action="listagemUsuario" method="post">
					<label for="nome"> Filtrar por nome: </label><br>
					<input type="text"	name="nome"><br> 
					
					<label for="senha"> Filtrar por senha: </label><br>
					<input type="text" name="senha"><br>
					
					<label for="nome"> Filtrar por ID: </label><br> 
					<input type="text" name="id"><br>
					
					<input class="mt-2" type="submit" value="Buscar">
				</form>
			</blockquote>
		</div>
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

			if(lista != null){
				for (Usuario usuario : lista) {
			%>
			<tr>
				<td><%=usuario.getId()%></td>
				<td><%=usuario.getNome()%></td>
				<td><%=usuario.getSenha()%></td>
				<td><a type="button" class="btn btn-warning"
					href="/Sprint4/mostraUsuario?id=<%=usuario.getId()%>">EDITAR</a></td>
				<td><a type="button" class="btn btn-danger" onclick="return confirm('Você deseja realmente excluir esse usuario?')"
					href="/Sprint4/removerUsuario?id=<%=usuario.getId()%>">EXCLUIR</a></td>
			</tr>
			<%
				}
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