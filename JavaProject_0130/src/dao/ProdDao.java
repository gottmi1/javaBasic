package dao;

import java.util.List;

import util.JDBCUtil;
import vo.ProdVo;

public class ProdDao {
	private static ProdDao instance = null;
	JDBCUtil jdbc = JDBCUtil.getInstance();

	private ProdDao() {
	}

	public static ProdDao getInstance() {
		if (instance == null) {
			instance = new ProdDao();
		}
		return instance;
	}

	public List<ProdVo> prodList() {
		String sql = "SELECT PROD_NO, PROD_NAME, PROD_PRICE, PROD_TYPE FROM JAVA_PROD WHERE DELYN IS NULL";

		return jdbc.selectList(sql, ProdVo.class);
	}

	public void prodUpdate(List param,int sel) {
		String sql = "UPDATE JAVA_PROD SET ";
		
		if (sel == 1 || sel == 4) {
			sql += " PROD_NAME = ? ";
			if( sel == 4) sql += ",";
		}
		if (sel == 2 || sel == 4) {
			sql += " PROD_PRICE = ? ";
			if( sel == 4) sql += ",";
		}
		if (sel == 3 || sel == 4) {
			sql += " PROD_TYPE = ? ";
		}
		
		sql += " WHERE PROD_NO = ?";
		
		jdbc.update(sql, param);
	}
	
	public void prodDelete(int sel) {
		String sql = "UPDATE JAVA_PROD SET DELYN = 'Y' WHERE PROD_NO = " + sel;
		
		jdbc.update(sql);
	}
	
	public void prodAdd(List param) {
		String sql = "INSERT INTO JAVA_PROD VALUES((SELECT NVL(MAX(PROD_NO),0) + 1 AS PROD_NO\r\n" + 
				"  FROM JAVA_PROD), ?,?,?,NULL)";
		
		jdbc.update(sql,param);
	}
}
