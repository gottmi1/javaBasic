package service;

import java.util.List;

import dao.CartProdDao;
import vo.CartProdVo;

public class CartProdService {
	private static CartProdService instance = null;
	CartProdDao dao = CartProdDao.getInstance();
		
	private CartProdService() {
	}

	public static CartProdService getInstance() {
		if (instance == null) {
			instance = new CartProdService();
		}
		return instance;
	}
	
	public List<CartProdVo> cartProdList() {
		return dao.cartProdList();
	}
}
