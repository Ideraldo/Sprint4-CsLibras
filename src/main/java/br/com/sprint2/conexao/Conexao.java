package br.com.sprint2.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import br.fiap.leitor.Leitor;

public class Conexao {
	private volatile static Connection connection;
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private static String user = "RM85934";
	private static String password = "241000";

	// construtor privado (não permite instanciação externa)
	private Conexao() {
	}

	// método para conectar e retornar a conexão
	public static Connection conectar() {
		if (connection == null) {
			synchronized (Conexao.class) {
				if (connection == null) {
					/*Properties prop = Leitor.getProp();
					String driver = prop.getProperty("driver");
					String url = prop.getProperty("url");
					String user = prop.getProperty("user");
					String password = prop.getProperty("password");	*/				
					try {
						Class.forName(driver);
						connection = DriverManager.getConnection(url, user, password);
					} catch (final ClassNotFoundException | SQLException e) {
						System.out.println(e);
					}
				}
			}
		}

		return connection;
	}
}
