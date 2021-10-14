package br.com.sprint2.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sprint2.dao.UsuarioDAO;
import br.com.sprint2.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listagemUsuario")
public class ListagemUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> lista = dao.listar();

		// FILTROS DA REQUISIÇÃO
		// Verifica se tem o parametro id na requisição para fazer o filtro
		if ((request.getParameter("id") == null || request.getParameter("id").equals(""))
				&& (request.getParameter("nome") == null || request.getParameter("nome").equals(""))
				&& (request.getParameter("senha") == null || request.getParameter("senha").equals(""))) {

			Collections.sort(lista, Comparator.comparingInt(Usuario::getId));

		} else
		// Filtrando APENAS pelo ID
		if ((request.getParameter("senha") == null || request.getParameter("senha").equals(""))
				&& (request.getParameter("nome") == null || request.getParameter("nome").equals(""))
				&& (request.getParameter("id") != null || !request.getParameter("id").equals(""))) {

			lista = lista.stream().filter(l -> l.getId() == Integer.parseInt(request.getParameter("id")))
					.collect(Collectors.toList());
			Collections.sort(lista, Comparator.comparingInt(Usuario::getId));

		} else
		// Filtrando apenas pelo NOME
		if ((request.getParameter("id") == null || request.getParameter("id").equals(""))
				&& (request.getParameter("senha") == null || request.getParameter("senha").equals(""))
				&& (request.getParameter("nome") != null && !request.getParameter("nome").equals(""))) {

			lista = lista.stream().filter(l -> l.getNome().equals(request.getParameter("nome")))
					.collect(Collectors.toList());
			Collections.sort(lista, Comparator.comparingInt(Usuario::getId));

		} else
		// Filtrando APENAS pela SENHA
		if ((request.getParameter("id") == null || request.getParameter("id").equals(""))
				&& (request.getParameter("nome") == null || request.getParameter("nome").equals(""))
				&& (request.getParameter("senha") != null && !request.getParameter("senha").equals(""))) {

			lista = lista.stream().filter(l -> l.getSenha().equals(request.getParameter("senha")))
					.collect(Collectors.toList());
			Collections.sort(lista, Comparator.comparingInt(Usuario::getId));
		} else

		// Filtrando por NOME e SENHA
		if ((request.getParameter("id") == null || request.getParameter("id").equals(""))
				&& (request.getParameter("nome") != null || !request.getParameter("nome").equals(""))
				&& (request.getParameter("senha") != null && !request.getParameter("senha").equals(""))) {

			String senha = request.getParameter("senha");
			String nome = request.getParameter("nome");

			lista = lista.stream().filter(l -> l.getNome().equals(nome) && l.getSenha().equals(senha))
					.collect(Collectors.toList());
			Collections.sort(lista, Comparator.comparingInt(Usuario::getId));

		} else if ((request.getParameter("id") != null || !request.getParameter("id").equals(""))
				&& (request.getParameter("nome") != null || !request.getParameter("nome").equals(""))
				&& (request.getParameter("senha") != null && !request.getParameter("senha").equals(""))) {

			String senha = request.getParameter("senha");
			String nome = request.getParameter("nome");

			lista = lista.stream().filter(l -> l.getNome().equals(nome) && l.getSenha().equals(senha)
					&& l.getId() == Integer.parseInt(request.getParameter("id"))).collect(Collectors.toList());
			Collections.sort(lista, Comparator.comparingInt(Usuario::getId));

		} else {
			lista = new ArrayList<Usuario>();
		}

		request.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listagemUsuario.jsp");
		dispatcher.forward(request, response);

	}

}
