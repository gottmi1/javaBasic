package service;

import java.util.List;
import java.util.Map;

import dao.LibDao;
import util.JDBCUtil;
import vo.BookVo;

public class LibService {
	private static LibService instance = null;
	LibDao dao = LibDao.getInstance();
	
	private LibService() {
	}

	public static LibService getInstance() {
		if (instance == null) {
			instance = new LibService();
		}
		return instance;
	}
	
	public List<BookVo> list() {
		return dao.list();
	}
	
	public BookVo detail(int bookNo) {
		BookVo book = dao.detail(bookNo);
		String content = book.getContent();
		String temp = "";
		for(int i = 0; i < content.length() / 20; i++) {
			if(20+i * 20 >content.length()) {
				temp += content.substring(i*20,content.length()) + "\n";
			}else {
				temp += content.substring(+i*20, 20+i*20) + "\n";
			}
		} 
		if(content.length() < 20) temp = content;
		book.setContent(temp);
		
		return book; 
	}
	
	public void update(List param) {
		dao.update(param);
	}
	
	public void delete(List param) {
		dao.delete(param);
	}
	
	public void insert(List param) {
		dao.insert(param);
	}
}
