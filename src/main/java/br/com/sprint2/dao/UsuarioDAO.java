package br.com.sprint2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sprint2.conexao.Conexao;
import br.com.sprint2.model.Usuario;

public class UsuarioDAO {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public UsuarioDAO() {
		connection = Conexao.conectar();
	}
	
	public void inserir(Usuario Usuario) {
		sql = "insert into LOGIN_USUARIOS (nome, senha) values (?, ?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, Usuario.getNome());
			ps.setString(2, Usuario.getSenha());
			ps.execute();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<Usuario>();
		sql = "select * from LOGIN_USUARIOS";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(new Usuario(rs.getString("nome"), rs.getString("senha"), rs.getInt("id")));
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return lista;
	}

	public void remover(int id) {
		sql = "DELETE from LOGIN_USUARIOS where id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public Usuario buscarPorId(int id) {
		Usuario usuario = new Usuario();
		//sql = "SELECT * FROM LOGIN_USUARIOS WHERE id = (?)";
		sql = "select * from LOGIN_USUARIOS where id = ?"; 

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setId(rs.getInt("id"));
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return usuario;
	}
	
	public void atualizarUsuario(Usuario usuario) {
		 String sql = "update LOGIN_USUARIOS set nome = ?, senha = ? where id = ?";
	        connection = Conexao.conectar();
	        try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setString(1, usuario.getNome());
	            stmt.setString(2, usuario.getSenha());
	            stmt.setInt(3, usuario.getId());
	        
	            stmt.execute();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	   }
	
	
}
