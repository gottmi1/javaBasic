package service;

import java.util.List;

import dao.ProdDao;
import vo.CartProdVo;
import vo.ProdVo;

public class ProdService {
	private static ProdService instance = null;
	ProdDao dao = ProdDao.getInstance();

	private ProdService() {
	}

	public static ProdService getInstance() {
		if (instance == null) {
			instance = new ProdService();
		}
		return instance;
	}

	public List<ProdVo> prodList() {
		return dao.list();
	}
	
	public List<ProdVo> search(List<Object> param, int sel) {
		return dao.search(param, sel);
	}
	
	public void cartInsert(List param) {
		dao.cartInsert(param);
	}
	
	public void cartProdInsert(List param) {
		dao.cartProdInsert(param);
	}
	
	public List<CartProdVo> cartProdList() {
		return dao.cartProdList();
	}
	
	public void prodUpdate(List param, int sel) {
		dao.prodUpdate(param, sel);
	}
	
	public void prodDelete(int sel) {
		dao.prodDelete(sel);
	}
	
	public void prodAdd(List param) {
		dao.prodAdd(param);
	}
}
