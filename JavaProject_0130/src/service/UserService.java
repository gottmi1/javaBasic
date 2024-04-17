package service;

import java.util.List;

import dao.UserDao;
import vo.UserVo;

public class UserService {
	private static UserService instance = null;
	UserDao dao = UserDao.getInstance();
	
	private UserService() {
	}

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	public List<UserVo> userList() {
		return dao.userList();
	}
	
	public List buyMemberList(int sel) {
		return dao.buyMemberList(sel);
	}
}
