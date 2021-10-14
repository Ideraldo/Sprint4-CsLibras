package br.com.sprint2.servlet;

import java.io.IOException;

import br.com.sprint2.dao.UsuarioDAO;
import br.com.sprint2.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/alteraUsuario")
public class AlteraUsuario extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Alterando usuario");
		
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		String paramId = request.getParameter("id");
		int id = Integer.valueOf(paramId);
				
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		Usuario usuarioEncontrado = dao.buscarPorId(id);
		
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setId(usuarioEncontrado.getId());
		
		dao.atualizarUsuario(usuario);
		
		response.sendRedirect("listagemUsuario");
	
	}

}

