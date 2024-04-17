package kr.or.ddit.study06.sec03;

public class Constructor {
	int a;
	int b;
	int c;
	int d;

	public Constructor() {

	}

	public Constructor(int a) {
//		this.a = a;
//		this.b = 20;
		this(a,20);
		System.out.println("Construct a 호출");
	}

	public Constructor(int a, int b) {
		this(a,b,10,10);
		System.out.println("Construct a b 호출");
	}

	public Constructor(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		
		System.out.println("Construct a b c d 호출");
	}

}
