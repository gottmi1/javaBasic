package service;

import java.util.List;

import dao.ProdDao;
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
		return dao.prodList();
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
