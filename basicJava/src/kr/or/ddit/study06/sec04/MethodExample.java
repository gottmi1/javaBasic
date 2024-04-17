package kr.or.ddit.study06.sec04;

public class MethodExample {
	public static void main(String[] args) {

		System.out.println("메인 메소드");

		MethodExample me = new MethodExample();

		me.method01();

		int i1 = me.method02();
		System.out.println("method2 리턴 값 : " + i1);

		double d1 = me.method03();
		System.out.println("method3 리턴 값 : " + d1);

		int[] a = me.m4(10);
		System.out.println(a[0]);
	}

	public void method01() {
		System.out.println("public void method1");
		System.out.println("리턴타입 void");
	}

	public int method02() {
		System.out.println("public int method2");
		System.out.println("리턴타입 int");

		return 123;
	}

	public int[] m4(int n) {
		int[] abc = new int[n];

		for (int i = 0; i < n; i++) {
			abc[i] = i;
		}

		return abc;
	}

	public double method03() {
		System.out.println("public double method3");
		System.out.println("리턴타입 double");

		return 123.123;
	}
}
