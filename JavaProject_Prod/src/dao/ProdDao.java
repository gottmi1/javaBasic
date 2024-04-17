package dao;

import java.util.List;

import util.JDBCUtil;
import vo.CartProdVo;
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

	public List<ProdVo> list() {
		String sql = " SELECT PROD_NO , PROD_NAME, PROD_PRICE, PROD_TYPE \r\n" + "   FROM JAVA_PROD";

		return jdbc.selectList(sql, ProdVo.class);
	}

	public List<ProdVo> search(List<Object> param, int sel) {
		String sql = "SELECT * " + "     FROM JAVA_PROD" + "    WHERE ";

		// 라이크의 연산자 사용시 ? 가 이상하게 들어갈 수 있어서 이렇게 해줘야 함
		if (sel == 1) {
			sql += "PROD_NAME LIKE '%'||?||'%'";
		}
		if (sel == 2) {
			sql += "PROD_TYPE LIKE '%'||?||'%'";
		}

		return jdbc.selectList(sql, param, ProdVo.class);
	}
	
	public void cartInsert(List param) {
		String sql = "INSERT INTO JAVA_CART VALUES(\r\n" + 
				"(SELECT NVL(MAX(CART_NO),0) + 1 AS CART_NO\r\n" + 
				"  FROM JAVA_CART), ?, SYSDATE)";
		
		jdbc.update(sql, param);
	}
	
	public void cartProdInsert(List param) {
		String sql = "INSERT INTO JAVA_CART_PROD VALUES((SELECT NVL(MAX(CART_NO),0) AS CART_NO\r\n" + 
				"  FROM JAVA_CART), ?,?)";
		
		jdbc.update(sql, param);
	}
	
	public List<CartProdVo> cartProdList() {
		String sql = " SELECT * \r\n" + 
				"   FROM JAVA_CART_PROD ";
		
		return jdbc.selectList(sql, CartProdVo.class);
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
