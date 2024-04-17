package service;

import java.util.List;
import java.util.Map;

import dao.FreeDao;

public class FreeService {
	private static FreeService instance = null;
	FreeDao freeDao = FreeDao.getInstance();
	
	private FreeService() {
	}

	public static FreeService getInstance() {
		if (instance == null) {
			instance = new FreeService();
		}
		return instance;
	}
	
	public List<Map<String, Object>> freeList() {
		return freeDao.freeList();
	}
	
	public Map<String, Object> freeDetail(List<Object> param) {
		return freeDao.freeDetail(param);
	}
	
	public void freeUpdate(List<Object> param) {
		freeDao.freeUpdate(param);
	}
	
	public void freeDelete(int boardNo) {
		freeDao.freeDelete(boardNo);
	}
	
	public void freeInsert(List<Object> param) {
		freeDao.freeInsert(param);
	}
}
