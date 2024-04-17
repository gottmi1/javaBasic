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
	
	public UserVo login(List param) {
		String sql = "    SELECT * \r\n" + 
				"      FROM JAVA_USER\r\n" + 
				"     WHERE MEM_ID = ?\r\n" + 
				"       AND MEM_PASS = ?";
		
		return jdbc.selectOne(sql, param,UserVo.class);
	}
	
	public List<UserVo> userList() {
		String sql = "SELECT MEM_ID , MEM_PASS, MEM_NAME, MEM_NO FROM JAVA_USER";
		
		return jdbc.selectList(sql, UserVo.class);
	}
	
	public List buyMemberList(int sel) {
		String sql = "SELECT D.MNAME AS 멤버명, D.MNO AS 멤버번호, C.PROD_NO AS 상품번호, C.QTY AS 구매수량 FROM (\r\n" + 
				"SELECT A.MEM_NAME AS MNAME,A.MEM_NO AS MNO ,B.CART_NO AS CNO FROM JAVA_USER A, JAVA_CART B WHERE A.MEM_NO = B.USER_NO\r\n" + 
				")D, JAVA_CART_PROD C\r\n" + 
				"WHERE D.CNO = C.CART_NO\r\n" + 
				"  AND D.MNO = " + sel;
		
		return jdbc.selectList(sql);
	}
}
