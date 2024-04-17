package kr.or.ddit.study06.sec04;

public class MethodExample02 {
	public static void main(String[] args) {

		MethodExample02 me = new MethodExample02();

		me.m1(10);
		me.m2("ㅗ");
		me.m3(22, 33);
	}

	public void m1(int n) {
		System.out.println("메소드 1에서 받은 파라미터 : " + n);
	}

	public void m2(String str) {
		System.out.println("메소드 2에서 받은 파라미터 : " + str);
	}

	public void m3(int a, int b) {
		System.out.println("메소드 3에서 받은 파라미터 : " + a + " " + b);
	}

}
