package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.UserVo;

public class UserDao {
	private static UserDao instance = null;
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	private UserDao() {
	}

	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	
	public UserVo login(List<Object> param) {
		String sql = "SELECT * \r\n" + 
				"      FROM JAVA_USER\r\n" + 
				"     WHERE MEM_ID = ?\r\n" + 
				"       AND MEM_PASS= ?";
		
		return jdbc.selectOne(sql, param, UserVo.class);
	}

	
}
