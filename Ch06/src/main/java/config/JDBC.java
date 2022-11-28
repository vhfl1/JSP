package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

public class JDBC {

	private static JDBC instance = new JDBC();
	
	public static JDBC getInstance() {
		return instance;
	}
	
	private JDBC() {}
	
	private final String host = "jdbc:mysql://127.0.0.1:3306/java1db";
	private final String user = "root";
	private final String pass = "1234";
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(host, user, pass);
	}
}