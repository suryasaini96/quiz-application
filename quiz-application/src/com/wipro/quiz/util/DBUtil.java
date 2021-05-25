package com.wipro.quiz.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getDBConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			connection = DriverManager.getConnection(url, user, password);
		} catch(Exception e) {
			System.out.println(e);
		}
		return connection;	
	}
	

}
