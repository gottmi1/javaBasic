package dao;

import java.util.List;

import util.JDBCUtil;
import vo.CartProdVo;

public class CartProdDao {
	private static CartProdDao instance = null;
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	private CartProdDao() {
	}

	public static CartProdDao getInstance() {
		if (instance == null) {
			instance = new CartProdDao();
		}
		return instance;
	}
	
	public List<CartProdVo> cartProdList() {
		String sql = "SELECT CART_NO, PROD_NO, QTY FROM JAVA_CART_PROD";
		
		return jdbc.selectList(sql,CartProdVo.class);
	}
}
