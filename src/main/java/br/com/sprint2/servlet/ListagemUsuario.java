package br.com.sprint2.servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> lista = dao.listar();
		
		//Deixa a lista na ordem correta para ser exibida.
		Collections.sort(lista, Comparator.comparingInt(Usuario::getId));
		
		request.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listagemUsuario.jsp");
		dispatcher.forward(request, response);
		
	}

}
