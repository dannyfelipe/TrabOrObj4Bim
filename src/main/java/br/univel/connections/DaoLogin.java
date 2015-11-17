package br.univel.connections;

/**
 * @author Danny Felipe, 12/11/2015 - 01:55:18
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DaoLogin {
	
	public Connection con;
	public Statement st;
	public ResultSet rs;
	
	/*
	 * par�metros para conex�o com o banco de dados
	 */
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/java_ooii";
	String user = "root";
	String password = "";
	
	/*
	 * M�todo de conex�o com o banco de dados atrav�s do driver jdbc para mysql
	 */
	public void openCon() {
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
