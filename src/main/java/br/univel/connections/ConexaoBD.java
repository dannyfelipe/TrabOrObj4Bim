package br.univel.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Danny Felipe, 01/11/2015 - 23:52:24
 * 
 * Classe de conexão com o sistema de banco de dados MySQL
 *
 */

public class ConexaoBD {
	
	private Connection con;
	
	private static ConexaoBD inst;
	
	private ConexaoBD() {
		
	}
	
	/*
	 * Cria somente uma instância de conexão, através do padrão Singleton
	 */
	public static ConexaoBD getInstace(){
		if(inst == null )
			return inst = new ConexaoBD();
		return inst;
	}
	
	/*
	 * Método de conexão com o banco de dados através do driver jdbc para mysql
	 */
	public Connection conOpen(){
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/java_ooii";
		String user = "root";
		String pass = "";
		try {
			Class.forName(driverName);
			return con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Método para fechar a conexão com o banco de dados 
	 */
	public boolean conClose(){
		try {
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
