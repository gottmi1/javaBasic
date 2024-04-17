package kr.or.ddit.study06.sec04;

public class MethodExample03 {
	public static void main(String[] args) {

		MethodExample03 me = new MethodExample03();
		me.m1();
	}

	public void m1() {
		m2();
		System.out.println("method1");

	}

	public void m2() {
		m3();
		System.out.println("method2");
	}

	public void m3() {
		System.out.println("method3");
	}

}
