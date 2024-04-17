package service;

import java.util.List;
import java.util.Map;

import controller.MainController;
import dao.UserDao;

public class UserService {
private static UserService instance = null;
	
	private UserService() {
		
	}
	
	public static UserService getInstance() {
		if(instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	UserDao userDao = UserDao.getInstance();
	
	public boolean login(List<Object> param) {
		Map<String, Object> user = userDao.login(param);
		
		if(user == null || user.isEmpty()) return false;
		
		// 세션 == 로그인정보를 가짐
		// 					세션			 attribute  value
		MainController.sessionStorage.put("user",user);
		
		return true;
	}

	public void join(List<Object> param) {
		userDao.join(param);
	}
	
	public List<Map<String,Object>> list() {
		return userDao.list();
	}
}
