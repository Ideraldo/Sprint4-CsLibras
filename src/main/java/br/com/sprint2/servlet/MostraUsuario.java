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

@WebServlet("/mostraUsuario")
public class MostraUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String paramId = request.getParameter("id");
		Integer id = Integer.parseInt(paramId);
		
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario usuario = dao.buscarPorId(id);
		
		System.out.println(usuario.getNome());

		request.setAttribute("usuario", usuario);
		
		RequestDispatcher rd = request.getRequestDispatcher("/alteraUsuario.jsp");
		rd.forward(request, response);
		
	}
	
}
