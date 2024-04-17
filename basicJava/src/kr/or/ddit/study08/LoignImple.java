package kr.or.ddit.study08;

public class LoignImple implements ILogin {

	@Override
	public boolean login(String id, String pass) {
		System.out.println("키보드를 통해 구현");
		return false;
	}

	@Override
	public boolean sign(String id, String pass, String name, String tell) {
		return false;
	}

}
