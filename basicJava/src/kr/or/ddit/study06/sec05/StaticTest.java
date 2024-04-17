package kr.or.ddit.study06.sec05;

public class StaticTest {
	
	int field = 10;
	static int static_field = 11;

	public static void main(String[] args) {
		StaticTest.s_m1();
		StaticTest.s_m2();
		System.out.println(StaticTest.static_field);
		
	}
	
	public void m1() {

	}

	public void m2() {

	}

	public static void s_m1() {
		// 스태틱 안에선 현재 클래스의 객체를 만들어야 static외의 한정자를 가진 것에 접근할 수 있음
		StaticTest st = new StaticTest();
		st.m1();
	}

	public static void s_m2() {
	}
}
