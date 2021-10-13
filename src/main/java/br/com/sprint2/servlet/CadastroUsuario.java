package br.com.sprint2.servlet;

import java.io.IOException;

import br.com.sprint2.dao.UsuarioDAO;
import br.com.sprint2.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastro")
public class CadastroUsuario extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//Faz o cadastro quando recebe requisição do tipo POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Cadastrando novo usuario...");
		
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		Usuario usuario = new Usuario(nome, senha);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.inserir(usuario);
		
		response.sendRedirect("listagemUsuario");
	}
	
	//Chama a pagina JSP
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroUsuario.jsp");
			dispatcher.forward(request, response);
			
	}
	

}
