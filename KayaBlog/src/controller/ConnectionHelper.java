package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper implements userAdminDB {
	
	static Connection conn = null;
	
	
	public static Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(userAdminDB,username,password);
			
		}catch (Exception e) {
			 System.out.println(e);
		}
		return conn;
	}
}
