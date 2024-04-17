package kr.or.ddit.study08;

public class BoardImple implements IBoard {

	@Override
	public void writeBoard(String title, String content) {

		ILogin login = null;

		// 핸드폰 여부 체크
		boolean phonChk = false;

		if (phonChk)
			login = new MobileLoginImple();
		else
			login = new LoignImple();

		login.login("id", "pass");

		// DB에 데이터 넣어주기
	}

}
