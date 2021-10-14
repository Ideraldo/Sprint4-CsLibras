package br.com.sprint2.servlet;

import java.io.IOException;

import br.com.sprint2.dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/removerUsuario")
public class RemoverUsuario extends HttpServlet{
private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Fazer a implementação do DELETE
		
		String paramId = request.getParameter("id");
		Integer id = Integer.parseInt(paramId);
				
		UsuarioDAO dao = new UsuarioDAO();
		dao.remover(id);
		
		response.sendRedirect("listagemUsuario");
	}
}
