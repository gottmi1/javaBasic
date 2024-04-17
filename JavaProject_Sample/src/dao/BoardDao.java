package dao;

import java.util.List;

import util.JDBCUtil;
import vo.BoardVo;

public class BoardDao {
	private static BoardDao instance = null;
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	private BoardDao() {
	}

	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	
	public List<BoardVo> list(List param) {
		String sql = "SELECT * FROM\r\n" + 
				"(SELECT ROWNUM RN, A.* FROM\r\n" + 
				"(SELECT B.BOARD_NO\r\n" + 
				"     , B.TITLE\r\n" + 
				"     , B.CONTENT\r\n" + 
				"     , TO_CHAR(B.REG_DATE) AS REG_DATE\r\n" + 
				"     , A.MEM_ID\r\n" + 
				"     , B.VIEW_CNT \r\n" + 
				" FROM JAVA_BOARD B, JAVA_USER A\r\n" + 
				"WHERE B.MEM_NO = A.MEM_NO\r\n" + 
				"AND B.DELYN IS NULL\r\n" +
				"ORDER BY B.BOARD_NO) A)\r\n" + 
				"WHERE RN BETWEEN ? AND ?";
		
		return jdbc.selectList(sql,param, BoardVo.class);
	}
	
	public void update(List param,int sel) {
		// 조건에 따른 쿼리 조합
		String sql = "UPDATE JAVA_BOARD " + 
				  "   SET ";
		if(sel == 1 || sel == 3) {
			sql += "TITLE = ?";
			if(sel == 3) sql += ",";
		} if(sel == 2 || sel == 3) {
			sql += "CONTENT = ?";
		}
		sql += " WHERE BOARD_NO = ?";
		
		jdbc.update(sql, param);
	}
	
	public BoardVo check(List param) {
		String sql = " SELECT MEM_NO\r\n" + 
				"   FROM JAVA_BOARD\r\n" + 
				"   WHERE MEM_NO = ?\r\n" + 
				"     AND BOARD_NO = ?";
		
		return jdbc.selectOne(sql, param,BoardVo.class);
	}
	
	public void delete(List param) {
		String sql = "UPDATE JAVA_BOARD SET DELYN = 'Y' WHERE BOARD_NO = ?";
		
		jdbc.update(sql, param);
	}
}
