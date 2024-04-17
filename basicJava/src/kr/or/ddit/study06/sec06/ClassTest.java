package kr.or.ddit.study06.sec06;

public class ClassTest {
	private static int year;
	private int feild1;

	public ClassTest() {

	}

	public ClassTest(int feild1) {
		this.feild1 = feild1;
	}

	// 오버라이드 : 부모가 만든 메서드 재정의
	// 여기서 부모는 Object
	@Override
	public String toString() {
		return "ClassTest [feild1=" + feild1 + "]";
	}

	
}
