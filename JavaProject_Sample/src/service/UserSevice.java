package service;

import java.util.List;

import controller.MainController;
import dao.UserDao;
import vo.UserVo;

public class UserSevice {
	private static UserSevice instance = null;
	UserDao dao = UserDao.getInstance();
	
	private UserSevice() {
	}

	public static UserSevice getInstance() {
		if (instance == null) {
			instance = new UserSevice();
		}
		return instance;
	}
	
	public boolean login(List<Object> param) {
		UserVo user = dao.login(param);
		
		if(user == null) return false;
		
		// 로그인 됐으면 세션 스토리지에 유저 저장
		MainController.sessionStorage.put("user",user);
		return true;
	}
}
