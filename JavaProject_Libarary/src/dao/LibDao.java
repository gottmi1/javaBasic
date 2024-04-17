package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.BookVo;

public class LibDao {
	private static LibDao instance = null;
	JDBCUtil jdbc = JDBCUtil.getInstance();

	private LibDao() {
	}

	public static LibDao getInstance() {
		if (instance == null) {
			instance = new LibDao();
		}
		return instance;
	}

	public List<BookVo> list() {
		String sql = "SELECT BOOK_NO\r\n" + "     , WRITER\r\n" + "     , TITLE\r\n"
				+ "     , SUBSTR(CONTENT,1,10) AS CONTENT\r\n" + "     , TO_CHAR(PUB_DATE,'YYYYMMDD') AS PUB_DATE \r\n"
				+ "     , PUB \r\n" + " FROM JAVA_LIBRARY\r\n" + " WHERE DELYN IS NULL";
		// Map을 사용할 땐 데이터타입을 명확히 알고 있어야 하는데,
		// Vo를 사용하면 타입이 미리 지정되어 있기 장점이 있음.

		return jdbc.selectList(sql, BookVo.class);
	}

	public BookVo detail(int bookNo) {
		String sql = "SELECT BOOK_NO\r\n" + "     , WRITER\r\n" + "     , TITLE\r\n" + "     , CONTENT\r\n"
				+ "     , TO_CHAR(PUB_DATE,'YYYYMMDD') AS PUB_DATE \r\n" + "     , PUB \r\n" + " FROM JAVA_LIBRARY\r\n"
				+ " WHERE BOOK_NO = " + bookNo;
		return jdbc.selectOne(sql, BookVo.class);
	}

	public void update(List param) {
		String sql = "UPDATE JAVA_LIBRARY\r\n" + "        SET TITLE = ?,\r\n" + "        	 CONTENT = ?\r\n"
				+ "      WHERE BOOK_NO = ?";

		jdbc.update(sql, param);
	}

	public void delete(List param) {
		String sql = "UPDATE JAVA_LIBRARY\r\n" + "           SET DELYN = 'Y'\r\n" + "            WHERE BOOK_NO = ?";

		jdbc.update(sql, param);
	}

	public void insert(List param) {
		String sql = "INSERT INTO JAVA_LIBRARY (BOOK_NO, TITLE, CONTENT, WRITER, PUB_DATE, PUB) \r\n"
				+ "        VALUES ((SELECT MAX(BOOK_NO) + 1 \r\n"
				+ "              FROM JAVA_LIBRARY), ?,?,?,TO_DATE(?),?)";

		jdbc.update(sql, param);
	}
}
