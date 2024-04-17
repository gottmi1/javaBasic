package service;

import java.util.List;

import dao.BoardDao;
import vo.BoardVo;

public class BoardService {
	private static BoardService instance = null;
	BoardDao dao = BoardDao.getInstance();
	
	private BoardService() {
	}

	public static BoardService getInstance() {
		if (instance == null) {
			instance = new BoardService();
		}
		return instance;
	}
	
	public List<BoardVo> list(List param) {
		return dao.list(param);
	}
	
	public void update(List param, int sel) {
		dao.update(param, sel);
	}
	
	public void delete(List param) {
		dao.delete(param);
	}
	
	public boolean check(List param) {
		BoardVo vo = dao.check(param);
		if(vo == null) return false;
		return true;
	}
}
