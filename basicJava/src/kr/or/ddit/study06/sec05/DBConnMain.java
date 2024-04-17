package kr.or.ddit.study06.sec05;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnMain {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public static void main(String[] args) {
		DBConnMain db = new DBConnMain();
		db.selectAll();
	}

	public void selectAll() {

		try {
			// SQL DB에 접속, 이걸 싱글톤으로 하는 이유는 연결을 한 번만 하기 위함
			conn = DBConn.getConnection();
			// SQL에 쿼리를 날려주는 역할
			stmt = conn.createStatement();

			String sql = " SELECT MEM_ID,MEM_NAME,MEM_BIR FROM MEMBER";
//					+ " WHERE SUBSTR(MEM_BIR,1,4) > '1980'";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String id = rs.getString("MEM_ID");
				String name = rs.getString("MEM_NAME");
				String bir = rs.getString("MEM_BIR");

				System.out.println(rs.getRow() + "\t" + id + "\t" + name + "\t" + bir);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
