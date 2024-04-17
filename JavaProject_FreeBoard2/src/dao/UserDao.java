package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class UserDao {
	private static UserDao instance = null;
	
	private UserDao() {
		
	}
	
	public static UserDao getInstance() {
		if(instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public Map<String,Object> login(List<Object> param) {
		String sql = " SELECT * \r\n" + 
				"       FROM JAVA_USER " + 
				"     	WHERE MEM_ID = ? \r\n" + 
				"       AND MEM_PASS = ? ";
//		Map<String,Object> user = jdbc.selectOne(sql,param);
		return jdbc.selectOne(sql,param);
	}

	public void join(List<Object> param) {
		String sql = " INSERT INTO JAVA_USER "
				+    " VALUES(?,?,?) ";
		
		jdbc.update(sql,param);
	}
	
	public List<Map<String,Object>> list() {
		String sql = " SELECT * FROM JAVA_USER";
		return jdbc.selectList(sql);
	}
	
//	public void login(String id, String pass) {
//		String sql = " SELECT * \r\n" + 
//				"      FROM MEMBER " + 
//				"     WHERE MEM_ID = '"+id+"'\r\n" + 
//				"       AND MEM_PASS = '"+pass+"'";
//		Map<String,Object> user = jdbc.selectOne(sql);
//		System.out.println(user);
//	}
}
