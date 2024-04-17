package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class FreeDao {
	private static FreeDao instance = null;

	private FreeDao() {
	}

	public static FreeDao getInstance() {
		if (instance == null) {
			instance = new FreeDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String, Object>> freeList() {
		String sql = " SELECT BOARD_NO, TITLE, CONTENT, WRITER, \r\n" + 
				"    TO_CHAR(REG_DATE,'YYYY.MM.DD') AS REG_DATE \r\n" + 
				"    FROM JAVA_FREEBOARD"  +
				"    WHERE DELYN IS NULL   ";
		
		return jdbc.selectList(sql);
	}
	
	public Map<String, Object> freeDetail(List<Object> param) {
		String sql = " SELECT BOARD_NO, TITLE, CONTENT, WRITER, \r\n" + 
				  "    TO_CHAR(REG_DATE,'YYYY.MM.DD') AS REG_DATE \r\n" + 
				  "    FROM JAVA_FREEBOARD " +
				  "    WHERE BOARD_NO = ?  ";
		
		// param에 들어있는 값을 ? 에 넣는다
		return jdbc.selectOne(sql, param);
	}
	
	public void freeUpdate(List<Object> param) {
		String sql = "  UPDATE JAVA_FREEBOARD\r\n" + 
				"       SET TITLE = ?,\r\n" + 
				"           CONTENT = ?\r\n" + 
				"     WHERE BOARD_NO = ?" ; 
		
		jdbc.update(sql, param);
	}
	
	public void freeDelete(int boardNo) {
		// DELETE 하는 방식은 그닥 안 사용 된다고 함 그래서 UPDATE를 사용
		String sql ="	 UPDATE JAVA_FREEBOARD\r\n" + 
				"           SET DELYN = 'Y'\r\n" + 
				"         WHERE BOARD_NO = " + boardNo;
		
		jdbc.update(sql);
	}
	
	public void freeInsert(List<Object> param) {
		String sql = "INSERT INTO JAVA_FREEBOARD (BOARD_NO, TITLE, CONTENT, WRITER, REG_DATE) \r\n" + 
				"        VALUES ((SELECT MAX(BOARD_NO) + 1 \r\n" + 
				"              FROM JAVA_FREEBOARD), ?,?,?,SYSDATE)";
		
		jdbc.update(sql, param);
	}
}
