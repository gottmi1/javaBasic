package kr.or.ddit.study06.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	private static Connection conn = null;

	// oracle DB접속
	public static Connection getConnection() {

		// localhost <- IP : 1521 <- PORT xe <- SID
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "psh";
		String pwd = "java";

		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, user, pwd);
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}

}
