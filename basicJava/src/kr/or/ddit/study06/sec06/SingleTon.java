package kr.or.ddit.study06.sec06;

public class SingleTon {

	private static SingleTon instance = null;

	int num = 0;
	private SingleTon() {
		num++;
	}

	public static SingleTon getInstance() {
		if (instance == null) {
			instance = new SingleTon();
		}
		return instance;
	}

}
