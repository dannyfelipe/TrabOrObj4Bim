package br.univel.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoLogin {
	
	public Connection con;
	public Statement st;
	public ResultSet rs;
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/java_ooii";
	String user = "root";
	String password = "";
	
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
